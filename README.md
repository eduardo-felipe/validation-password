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

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```

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