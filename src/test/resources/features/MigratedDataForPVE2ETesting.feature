Feature: End to end testing for migrated data

#  Scenario: Search for migrated PV,GP,SP and Release through PECO
#    Given Login to the ARAS Application as NM1
#    When Navigate to Product Portfolio and Project Management/Product Variants/Search Product Variants
#    Then User searches for migrated PV, GP, SP and release it

  #Tests Run automated scripts for Parts with distribution to MDG, retest in cycles until successful.
#  @CLIPP-31905 @CLIPP-31826 @CLIPP-31903 @MDG-MM @QA
#  Scenario: Search for migrated Parts and Release through ECO
#    Given Login to the ARAS Application as NM1
#    When Navigate to Design/Parts/Search Parts
#    Then User searches for migrated Parts and release it
#    #Then User searches for migrated Parts perform save as and release it


#  @CLIPP-29525 @DEV
#  Scenario: Search for migrated Parts and Release all through one ECO
#    Given Login to the ARAS Application as NM1
#    When Navigate to Design/Parts/Search Parts
#    And Search all the parts based on the excel file and store it
#    Then Add all parts one ECO and Release it

#  Scenario: Change Lifecycle for migrated Part items from Released to Obsolete
#    Given Login to the ARAS Application as NM1
#    When Navigate to Design/Parts/Search Parts
#    Then Search for the released migrated parts and change the lifecycle status of the parts to Obsolete

#  Scenario Outline: Take screenshot of parts
#    Given Login to the ARAS Application as NM1
#    When Navigate to Design/Parts/Search Parts
#    And User should search and open newly created Part from search page "<Part Item Code>"
#    Then takescreenshots "<Part Item Code>"
#    Examples:
#      | Part Item Code |
#      | 89.9983 |
#      | 89.9933 |
#      | 45.R847 |
#      | 44.AAZR |
#      | 43.Z577 |
#      | 32.FHU2 |
#      | 28.0006 |
#      | 28.0005 |
#      | 23.A562 |
#      | 7BIMN |
#      | 7BMDI |
#      | 7BFME |
#      | 7BITU |
#      | 7BITT |
#      | 6ABSX |
#      | 7BDXW |
#      | 7BFUI |
#      | 7BRBK |
#      | 7BNYX |
#      | 6AHSS |

#
  Scenario: Search for migrated Parts and Release all through one ECO
    Given Login to the ARAS Application as NM1
    #When Navigate to Design/Parts/Search Parts
    When Navigate to Change Management/ECOs/Create New ECO
    #And Search for all the parts based on the excel file add it one ECO and Release it


#  Scenario: Re-Run the ECO
#    Given Login to the ARAS Application as NM1
#    When Navigate to Change Management/ECOs/Search ECOs
#    #Then User searches for ECO and continue SingOff Process "ECO-00007030"
#    Then User searches for ECO and continue SingOff Process "ECO-00004834"


#  Scenario: Search for migrated mSpec and Release all through one MCO
#    Given Login to the ARAS Application as NM1
#    When Navigate to Change Management/MCOs/Create New MCO
#    And search with mSpec item code and fetch eBOM Revision and store it
