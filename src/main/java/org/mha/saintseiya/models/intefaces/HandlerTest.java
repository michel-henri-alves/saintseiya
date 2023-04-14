package org.mha.saintseiya.models.intefaces;

public interface HandlerTest {
    
    void testSuccess();

    void testRequiredFieldsIsNullError();

    void testRequiredFieldsIdBlankError();

    void testMaxFieldLengthSuccess();

    void testMaxFieldLengthExceededError();
}
