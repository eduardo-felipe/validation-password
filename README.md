# API de Validação de Senhas

Essa API tem por objetivo validar uma senha baseada em regras de caracteres.

Segue abaixo as regras de uma senha válida:

1. Nove ou mais caracteres
2. Ao menos 1 dígito
3. Ao menos 1 letra minúscula
4. Ao menos 1 letra maiúscula
5. Ao menos 1 caractere especial
6. Considere como especial os seguintes caracteres: !@#$%^&*()-+
7. Não possuir caracteres repetidos dentro do conjunto

Exemplos:

```javascript
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```
## Pré-requisitos
1. É necessário ter instalado o Java na versão 11 [Java SE Development Kit 11 Downloads](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html), escolhendo o Sistema Operacional que será usado na execução.

2. É necessário ter instalado o Maven (de preferência na versão mais recente). [Maven](https://maven.apache.org/download.cgi)

3. Para execução via Docker, é necessário ter instalado o Docker (de preferência na versão mais recente). [Docker](https://www.docker.com/)

## Execução do Projeto (Manual)

Clonar o projeto:

```bash
git clone https://github.com/eduardo-felipe/validation-password.git
```
Entrar no diretório do projeto:

```bash
cd /validation-password
```

Executar o comando Maven, conforme abaixo:
```bash
mvn clean install
```

Executar o JAR do Projeto:
```bash
java -jar target\validation-password-0.0.1-SNAPSHOT.jar
```
## Execução do Projeto (Docker)
```bash
docker run -p 8080:8080 eduardofal1987/validation-password:v1.0
```
## Detalhes da Solução

1. Escolhi utilizar a linguagem de programação Java, usando o Spring como Framework para facilitar a criação da API Web usando o padrão MVC. 

2. Também foi utilizado o projeto Lombok para facilitar e diminuir a quantidade e complexidade do código (exemplo gerar Getters e Setters e construtores).

3. Foi utilizado o JUNIT para testes unitários, pois é um dos frameworks de testes mais utilizados para a linguagem.

4. Foi utilizado a especificação OpenApi/Swagger para documentação da API.

5. Em relação ao Design da API, considerei o uso do verbo POST, pois ele é o mais recomendado quando tratamos de dados sensíveis como uma senha. Ele acaba sendo um pouco mais seguro, pois o dado não fica visível na URL e nem fica armazenado em histórico de navegadores, pois o mesmo é trafegado através de do body da requisição.

6. A solução foi baseada em um serviço de Validação de Senha, porém todos as validações foram realizadas em métodos separados para segmentar as responsabilidades, fazendo com que cada método tivesse somente 1 objetivo.

7. Foram criadas exceções especificas para cada validação, afim de melhorar a visibilidade entre o que é uma regra de negócio e uma exceção da aplicação.

## Premissas

1. Foi incluído uma mensagem de retorno no response para informar qual o motivo da senha não ser valida.

2. Foi incluído uma package de testes integrados no próprio repositório.

3. Foi criado uma imagem docker para facilitar a preparação do ambiente do projeto.