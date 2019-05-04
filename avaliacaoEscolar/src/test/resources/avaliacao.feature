Feature: Avaliacao escolar

  Scenario Outline: testar valores invalidos

    Given que quero testar valores invalidos
    When eu informar os valores invalidos <nota1> e <nota2> e <faltas> e <cargaHoraria>
    Then o sistema reporta uma excecao do tipo DadosInvalidosException

    Examples:
    |nota1|nota2|faltas|cargaHoraria|
    |-1.0|0.0|17|64|
    |0.0|-1.0|17|64|
    |0.0|0.0|-1|64|
    |0.0|0.0|16|-64|
    |11.0|10.0|16|64|
    |10.0|11.0|16|64|
    |10.0|10.0|65|64|

  Scenario Outline: testar reprovacao por falta
	 Given que eu quero testar a reprocao por falta
	 When eu informar os valores <nota1> e <nota2> e <faltas> e <cargaHoraria> , cuja quantidade de faltas supera o limite permitido
	 Then o sistema informa que o aluno foi reprovado por falta.

	Examples:
      |nota1|nota2|faltas|cargaHoraria|
      |6.5|7.5|17|64|
      |8.0|9.0|64|64|

  Scenario Outline: testar prova extra
	 Given que eu quero testar a prova extra
	 When eu informar os valores <nota1> e <nota2> e <faltas> e <cargaHoraria> que garatem a prova extra
	 Then o sistema deve informar que o aluno devera fazer uma prova extra

	Examples:
      |nota1|nota2|faltas|cargaHoraria|
      |3.01|3.01|10|64|
      |5.99|5.99|10|64|


  Scenario Outline: testar reprovacao por media
    Given que eu quero testar reprovacao por media
    When eu informar os valores <nota1> e <nota2> e <faltas> e <cargaHoraria> que garatem a reprovacao por media
    Then o sistema deve informar que o aluno foi reprovado por media

    Examples:
      |nota1|nota2|faltas|cargaHoraria|
      |1.0|1.0|10|64|
      |2.99|2.99|10|64|

	Scenario Outline: testar aprovacao
		Given que eu quero testar a aprovacao
		When eu informar os valores <nota1> e <nota2> e <faltas> e <cargaHoraria> que garatem a aprovacao
    Then o sistema deve informar que o aluno foi aprovado

	Examples:
	|nota1|nota2|faltas|cargaHoraria|
   |6.01|6.01|10|64|
   |10.00|10.00|10|64|
