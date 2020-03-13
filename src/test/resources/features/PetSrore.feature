@category-all
Feature: PetStore

########################################################################################################################

  @category-one
  Scenario: Add pet into shop (POJO conversion example)
    Given get unique pet id
    And create pet with params
      | categoryId | categoryName       | petName       | petPhotoUrls                            | tags                            | petStatus |
      | 1101       | Some Category Name | Some Pet Name | http://someUrl1.com,http://someUrl2.com | 99:Some Tag Name,101:Second tag | available |
    And check creation of pet
    And delete created pet
    And check deletion of pet

########################################################################################################################

  @category-two
  Scenario: 2Add pet into shop (POJO conversion example)
    Given get unique pet id
    And create pet with params
      | categoryId | categoryName       | petName       | petPhotoUrls                            | tags                            | petStatus |
      | 1101       | Some Category Name | Some Pet Name | http://someUrl1.com,http://someUrl2.com | 99:Some Tag Name,101:Second tag | available |
    And check creation of pet
    And delete created pet
    And check deletion of pet

########################################################################################################################