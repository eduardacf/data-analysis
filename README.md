### Sistema de análise de dados

> O sistema deve ser capaz de importar lotes de arquivos simples, ler e analisar os dados e
emitir um relatório.

#### Como executar:

- Basta acessar o diretório do sistema e digitar:

`gradle run
`

##### Sobre o arquivo .dat que deverá ser inserido no diretório:

- Existem 3 IDs possíveis, cada um representando um tipo específico de dados:

> - 001 - para o vendedor
> - 002 -  para o cliente
> - 003  -  para à venda

**Exemplo de arquivo:**

001ç1234567891234çDiegoç50000 001ç3245678865434çRenatoç40000.99

002ç2345675434544345çJose da SilvaçRural

002ç2345675433444345çEduardoPereiraçRural

003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego

003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato


#### Sobre o sistema:

- Lê arquivos localizados em HOMEPATH%/data/in. O sistema só deve ler. dat arquivos.

- O sistema deve criar um arquivo simples dentro do diretório de saída padrão, localizado em %HOMEPATH%/data/out

- O conteúdo do arquivo de saída contém os seguintes dados:

> - Quantidade de clientes no arquivo de entrada
> - Quantidade de vendedor no arquivo de entrada
> - ID da venda mais cara
> - Pior vendedor de cada vez

***Desenvolvido por Eduarda correia ferreira***

