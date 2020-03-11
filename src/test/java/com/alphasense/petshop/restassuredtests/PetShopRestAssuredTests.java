package com.alphasense.petshop.restassuredtests;

import com.alphasense.petshop.controllers.PetController;
import com.alphasense.petshop.dataModels.Pet;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

public class PetShopRestAssuredTests {

    @Test
    public void Test() {
        int idTestValue = RandomUtils.nextInt(0, 9000);
        String testPetName = RandomStringUtils.randomAlphabetic(5);
//        Pet testPet = Pet.createPetFromMap();

        Pet petTest = new Pet(testPetName, idTestValue, null, null, null, "AVAILABLE");

        Pet pet = new PetController().addPet(petTest);

        Assert.assertEquals(pet, petTest);

        System.out.println("\n\n\n\n\n");

        Pet getPet = new PetController().getPet(String.valueOf(pet.getId()));


    }
}
