
Scenario: A sum
Given number {1} and {3}
When I press calculate sum
Then I see 4


Scenario: A sum with examples
Given number <a> and <b>
When I press calculate sum
Then I see <result>
Examples:
| a | b | result |
| 1 | 2 |  3     |
| 3 | 4 |  7     |




