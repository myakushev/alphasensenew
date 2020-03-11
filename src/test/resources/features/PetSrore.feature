Feature: test


==============================================================================

  @category-two
  Scenario: Add pet into shop (POJO conversion example)
    Given set unique pet id in context
    And send create pet request with params
      | petId    | categoryId | categoryName       | petName       | petPhotoUrls                            | tagId | tagName       | petStatus |
      | ${petId} | 1101       | Some Category Name | Some Pet Name | http://someUrl1.com,http://someUrl2.com | 99    | Some Tag Name | available |
    And check create pet response 200
    And check creation of pet with id "${petId}"
    And send delete pet request for "${petId}"
    And check deleting of pet with id "${petId}"