# Corpus Banco de Redações UOL Educação

Textos de redações extraídos para o formato JSON visando utilização em algoritmos de inteligência artificial para pesquisa.

## Termos de Uso:

Copyright UOL. Todos os direitos reservados. É permitida a reprodução apenas em trabalhos escolares, sem fins comerciais e desde que com o devido crédito ao UOL e aos autores.
FONTE: http://educacao.uol.com.br/bancoderedacoes/


## Classificação:
| Item           | Descrição                       |
| -------------- | ------------------------------- |
| Gênero Textual | Informativo (IF) - Dissertações |
| Tipo Textual   | Outros                          |
| Domínio        | Generalidades ( Educação )      |


## Índice:

| Arquivo                      | Bytes    | Palavras  | Redacoes | Tema                                                   |
| :---                         |     ---: |      ---: |   :---:  | :---                                                   |
| uoleducacao_redacoes_01.json |  97.070  |  15.174   | 20       | Forma física, corpo perfeito e consumismo              |
| uoleducacao_redacoes_02.json | 100.778  |  16.066   | 20       | Impeachment: a presidente deve perder o mandato?       |
| uoleducacao_redacoes_03.json |  91.959  |  14.605   | 20       | Carta-convite: discutir discriminação na escola        |
| uoleducacao_redacoes_04.json |  95.974  |  14.768   | 20       | A tecnologia e a eliminação de empregos                |
| uoleducacao_redacoes_05.json |  88.036  |  13.723   | 20       | Por que o Brasil não consegue vencer o Aedes aegypti?  |
| uoleducacao_redacoes_06.json |  90.139  |  14.053   | 20       | Mariana: fatalidade ou negligência?                    |
| uoleducacao_redacoes_07.json |  93.310  |  14.949   | 20       | Bandido bom é bandido morto?                           |
| uoleducacao_redacoes_08.json |  81.079  |  12.789   | 19       | O sucesso vem da escola ou do esforço individual?      |
| uoleducacao_redacoes_09.json |  86.074  |  13.460   | 20       | Disciplina, ordem e autoridade favorecem a educação?   |
| **Total:**                   | 824.419  | 129.587   | 179      |                                                        |


## Estrutura JSON:
```
{
  "tema": "Título do tema.",
  "data": "Data de publicação no formato yyyy-mm-ddThh:mi",
  "contexto": "Texto de introdução da proposta.",
  "redacoes": [
  {
    "titulo": "Título da redação.",
    "nota": <Double de 0.0 a 10.0>,
    "texto": " Texto original da redação, com <BR> demarcando as quebras de linha.",
    "texto_corrigido": "Texto html com as correções efetuadas pelos professores do Uol Educação.",
    "analise": "Breve análise dos professores."
  },
  {
   ...
   }
  ]
}
```
