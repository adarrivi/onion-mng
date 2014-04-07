package com.adarrivi.norelational.adapter;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.adarrivi.core.entity.Bone;
import com.adarrivi.norelational.exception.InvalidEntityException;
import com.adarrivi.test.ExpectedResult;
import com.adarrivi.test.builder.TestCoreBuilder;

@RunWith(MockitoJUnitRunner.class)
public class JsonParserComponentTest {

    private static final String EMPTY_STRING = "";

    private static final String JSON_STRING = "{ name : humerus }";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private ObjectMapperProvider objectMapperProvider;

    @InjectMocks
    private JsonParserComponent victim = new JsonParserComponent();

    private ExpectedResult expectedResult;

    private Object inputEntity;
    private Class<?> inputEntityClass;
    private String inputJsonString;

    @Before
    public void setUp() {
        Mockito.when(objectMapperProvider.getObjectMapper()).thenReturn(objectMapper);
        expectedResult = new ExpectedResult();
    }

    @Test
    public void toJsonStringNull_ThrowEx() {
        expectedException.expect(InvalidEntityException.class);
        givenEntity(null);
        whenToJsonString();
    }

    private void givenEntity(Object entity) {
        inputEntity = entity;
    }

    private void whenToJsonString() {
        expectedResult.setResult(victim.toJsonString(inputEntity));
    }

    @Test
    public void toJsonString_ParsesToJsonString() throws IOException {
        Bone bone = TestCoreBuilder.createBone();
        givenEntity(bone);
        givenParsedJsonString(JSON_STRING);
        whenToJsonString();
        expectedResult.thenShouldBeEqualsTo(JSON_STRING);
    }

    private void givenParsedJsonString(String givenString) throws IOException {
        Mockito.when(objectMapper.writeValueAsString(inputEntity)).thenReturn(givenString);
    }

    @Test
    public void toJsonString_UnexpectedIOException_ThrowsInvalidEntityEx() throws IOException {
        expectedException.expect(InvalidEntityException.class);
        Bone bone = TestCoreBuilder.createBone();
        givenEntity(bone);
        givenUnexpectedIOExceptionParsingAsString();
        whenToJsonString();
    }

    private void givenUnexpectedIOExceptionParsingAsString() throws IOException {
        Mockito.doThrow(IOException.class).when(objectMapper).writeValueAsString(inputEntity);
    }

    @Test
    public void toJsonEntity_Null_ThrowsInvalidEntityEx() {
        expectedException.expect(InvalidEntityException.class);
        givenJsonString(null, Bone.class);
        whenToJsonEntity();
    }

    private void givenJsonString(String jsonString, Class<?> entityClass) {
        inputJsonString = jsonString;
        this.inputEntityClass = entityClass;
    }

    private void whenToJsonEntity() {
        expectedResult.setResult(victim.toJsonEntity(inputJsonString, inputEntityClass));
    }

    @Test
    public void toJsonEntity_EmptyString_ThrowsInvalidEntityEx() {
        expectedException.expect(InvalidEntityException.class);
        givenJsonString(EMPTY_STRING, Bone.class);
        whenToJsonEntity();
    }

    @Test
    public void toJsonEntity_UnexpectedIOEx_ThrowsInvalidEntityEx() throws IOException {
        expectedException.expect(InvalidEntityException.class);
        givenJsonString(JSON_STRING, Bone.class);
        givenIOExWhenParsingString();
        whenToJsonEntity();
    }

    private void givenIOExWhenParsingString() throws IOException {
        Mockito.doThrow(IOException.class).when(objectMapper).readValue(inputJsonString, inputEntityClass);
    }

    @Test
    public void toJsonEntity_ReturnsEntityFromMapper() throws IOException {
        Bone bone = TestCoreBuilder.createBone();
        givenJsonString(JSON_STRING, bone.getClass());
        givenParsedEntity(bone);
        whenToJsonEntity();
        expectedResult.thenShouldBeEqualsTo(bone);
    }

    @SuppressWarnings("unchecked")
    private void givenParsedEntity(Object entity) throws IOException {
        Mockito.when(objectMapper.readValue(inputJsonString, (Class<Object>) inputEntityClass)).thenReturn(entity);
    }

}
