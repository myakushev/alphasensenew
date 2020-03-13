package com.alphasense.petshop.tests.restassuredtests;

import com.alphasense.petshop.tests.controllers.PetController;
import com.alphasense.petshop.tests.datamodels.petmodel.Pet;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class PetShopRestAssuredTests {

    @Test
    public void Test() {
        int idTestValue = RandomUtils.nextInt(0, 9000);
        String testPetName = RandomStringUtils.randomAlphabetic(5);
//        Pet testPet = Pet.createPetFromMap();

        Pet petTest = new Pet(idTestValue, testPetName, null, null, null, "AVAILABLE");

        Response rs = new PetController().addPet(petTest);

        // Assert.assertEquals(pet, petTest);

        System.out.println("\n\n\n\n\n");

        // Pet getPet = new PetController().getPet(String.valueOf(pet.getId()));
        // System.out.println(getPet.getName());


    }
}
