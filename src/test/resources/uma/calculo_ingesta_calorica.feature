@tag
Feature: Calculation of recommended daily caloric intake

  @tag1
  Scenario Outline: Calculation of calorie intake for a man
    Given I am a man
    When I enter <weight>, <age>, <height> and "<gender>"  into the calculator
    Then I must receive a result that estimates my <recommended_daily_caloric>

    Examples:
        | weight | age | height | gender | recommended_daily_caloric |
        | 80     | 30  | 175    | h      | 1829.137                  |

  @tag2
  Scenario Outline: Calculation of calorie intake for a woman
    Given I am a woman
    When I enter <weight>, <age>, <height> and "<gender>"  into the calculator
    Then I must receive a result that estimates my <recommended_daily_caloric>

    Examples:
        | weight | age | height | gender | recommended_daily_caloric |
        | 60     | 25  | 160    | m      | 1389.843                  |

  @tag3
  Scenario Outline: Negative height
    Given I am a nutritionist
    When I enter <weight>, <age>, <height> and "<gender>"  into the calculator
    Then the calculator should display an error message

    Examples:
        | weight | age | height | gender | error |
        | 60     | 28  | 160    | m      | false |
        | 80     | 30  | 178    | h      | false |
        | 75     | 23  | -125   | m      | true  |

  @tag4
  Scenario Outline: Negative weight
    Given I am a nutritionist
    When I enter <weight>, <age>, <height> and "<gender>"  into the calculator
    Then the calculator should display an error message

    Examples:
        | weight | age | height | gender | error |
        | 60     | 28  | 160    | m      | false |
        | -80    | 30  | 178    | h      | true  |
        | 75     | 23  | 163    | m      | false |

  @tag5
  Scenario Outline: Negative age
    Given I am a nutritionist
    When I enter <weight>, <age>, <height> and "<gender>"  into the calculator
    Then the calculator should display an error message

    Examples:
        | weight | age | height | gender | error |
        | 60     | -28 | 160    | m      | true  |
        | 80     | 30  | 178    | h      | false |
        | 75     | 23  | 163    | m      | false |
