This is an implementation of [KataTennis](codingdojo.org/cgi-bin/wiki.pl?KataTennis)



Alternative specification
=========================

| description                             | balls won	| score         |
| --------------------------------------- | ----------- | --------------|
| before game starts                      | 			| 0  - 0        |
| single ball                             | s			| 15 - 0        |
| same player wins 2 balls                | rr			| 30 - 0        |
| same player wins 3 balls                | sss			| 40 - 0        |
| same player wins 4 balls - game ends    | rrrr		| r winner      |
| both players win balls                  | srss		| 40 - 15       |
| deuce 8 balls                           | srsrsrsr	| deuce         |
| deuce 10 balls                          | srsrsrsrsr	| deuce         |
| advantage                               | srsrsrsrr	| r advantage   |
| game ends after advantage               | srsrsrsrss	| s winner      |
| deuce after advantage                   | srsrsrsrsa	| deuce         |


#### Abrevations
s = server
r = receiver
