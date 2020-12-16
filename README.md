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

## Execução do Projeto (Manual)

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

## Usage

```python
import foobar

foobar.pluralize('word') # returns 'words'
foobar.pluralize('goose') # returns 'geese'
foobar.singularize('phenomena') # returns 'phenomenon'
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)