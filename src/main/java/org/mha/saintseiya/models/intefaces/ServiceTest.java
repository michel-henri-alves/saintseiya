package org.mha.saintseiya.models.intefaces;

public interface ServiceTest{

    void testCreationSuccess();

    void testCreationDuplicatedError();

    void testListingSuccess();
    
    void testGetByIdSuccess();

    void testGetByIdElementNotFound();
    
    void testUpdateSuccess();

    void testUpdateDuplicatedError();

    void testDeletionSucess();

    void testDeletionElementNotFoundError();
}
