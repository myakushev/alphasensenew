@category-all
Feature: PetStore

########################################################################################################################

  @category-one
  Scenario Outline: Add and delete pet (<petStatus>)
    Given get unique pet id
    And create pet with params
      | categoryId   | categoryName   | petName   | petPhotoUrls   | tags   | petStatus   |
      | <categoryId> | <categoryName> | <petName> | <petPhotoUrls> | <tags> | <petStatus> |
    And check creation of pet
    And delete created pet
    And check deletion of pet
    Examples:
      | categoryId | categoryName           | petName            | petPhotoUrls                               | tags                             | petStatus |
      | 1101       | Some category Name     | Some test Name     | http://someUrl1.com,http://someUrl2.com    | 99:Some Tag Name,101:Second tag  | available |
      | 1102       | Another category Name  | Another test Name  | http://someUrl3.com,http://someUrl2342.com | 102:Some Tag Name,105:Second tag | pending   |
      | 1103       | One more category Name | One more test Name | http://someUr51.com,http://someUrl99.com   | 11:Some Tag Name,76:Second tag   | sold      |

########################################################################################################################

  @category-two
  Scenario Outline: Create order and check status
    Given get unique order id
    And create order with params
      | petId   | quantity   | shipDate   | status   | complete   |
      | <petId> | <quantity> | <shipDate> | <status> | <complete> |
    And check creation of order
    Examples:
      | petId     | quantity | shipDate                     | status    | complete |
      | 401453232 | 1        | 2020-01-01T00:00:00.000+0000 | placed    | true     |
      | 401453232 | 2        | 2020-01-02T00:00:00.000+0000 | approved  | false    |
      | 401453232 | 3        | 2020-01-03T00:00:00.000+0000 | delivered | true     |

########################################################################################################################