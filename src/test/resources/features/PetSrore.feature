Feature: PetSrore

#==============================================================================

  Scenario: Add pet into shop (POJO conversion example)
    Given set unique pet id in context
    And send create pet request with params
      | categoryId | categoryName       | petName       | petPhotoUrls                            | tags                            | petStatus |
      | 1101       | Some Category Name | Some Pet Name | http://someUrl1.com,http://someUrl2.com | 99:Some Tag Name,101:Second tag | available |



#    And check create pet response 200
#    And check creation of pet with id "${petId}"
#    And send delete pet request for "${petId}"
#    And check deleting of pet with id "${petId}"