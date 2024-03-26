@tag
Feature: Basal Metabolic Rate Calculation

  @tag1
  Scenario Outline: Calculate the basal metabolic rate with valid input
    Given I am a man
    When I enter <weight>, <age>, <height> and "<gender>"  into the calculator
    Then I must receive a result that estimates my <expected_bmi>

    Examples:
        | weight | age | height | gender | expected_bmi |
        | 80     | 35  | 175    | h      | 26.07        |

  @tag2
  Scenario Outline: Calculate the basal metabolic rate with valid input
    Given I am a woman
    When I enter <weight>, <age>, <height> and "<gender>"  into the calculator
    Then I must receive a result that estimates my <expected_bmi>

    Examples:
        | weight | age | height | gender | expected_bmi |
        | 60     | 28  | 160    | m      | 23.44        |

  @tag3
  Scenario Outline: Display error when input parameter is incorrect
    Given I am a nutritionist 
    When I enter <weight>, <age>, <height> and "<gender>" into the calculator
    Then the calculator should display an error message stating the height cannot be negative

    Examples:
        | weight | age | height | gender | error |
        | 60     | 28  | 160    | m      | false |
        | 80     | 30  | 178    | h      | false |
        | 75     | 23  | -125   | m      | true  |
