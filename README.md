# sistema-bancario

O projeto presente no repositório é uma aplicação desenvolvida em Java como parte de uma disciplina acadêmica. O objetivo do projeto é fornecer uma interface intuitiva para realizar operações bancárias e gerenciar dados relacionados a funcionários, agências, clientes e contas bancárias.

A aplicação apresenta uma hierarquia de funcionalidades, permitindo a manutenção de dados como cadastrar funcionários gerentes e administrativos, alterar seus cargos, buscar e excluir funcionários. Também é possível cadastrar agências, alterar o gerente de uma agência, buscar e excluir agências.

Além disso, a aplicação permite cadastrar clientes, alterar suas informações de escolaridade, buscar e excluir clientes. É possível também cadastrar contas correntes, poupanças e salários, alterar o status da conta e buscar informações sobre as tarifas das contas.

A aplicação oferece relatórios que permitem listar agências, clientes, contas e funcionários cadastrados. Além disso, a funcionalidade de transações bancárias possibilita realizar saques, transferências e depósitos.

O projeto foi desenvolvido com ênfase na interface gráfica usando a biblioteca javax.swing, proporcionando uma experiência amigável ao usuário. No entanto, é importante seguir algumas observações, como a necessidade de vincular corretamente funcionários, clientes e agências já cadastrados ao cadastrar uma conta ou agência.

O projeto busca fornecer uma aplicação de banco simples, porém completa, com foco em aprender conceitos de programação orientada a objetos, manipulação de interfaces gráficas e gerenciamento de dados. Sua execução e uso seguem padrões da linguagem Java, tornando-o acessível para estudantes e entusiastas que desejam aprimorar suas habilidades de programação em Java.

## Observações Importantes para Execução

Antes de iniciar a aplicação, atente-se às seguintes observações para que tudo funcione corretamente:

Para cadastrar uma agência, é necessário vincular um gerente já cadastrado na aplicação.
Para cadastrar um cliente, é necessário vincular uma agência já cadastrada na aplicação.
Para cadastrar uma conta, é necessário vincular uma agência e um cliente já cadastrados na aplicação.
Caso esses passos não sejam seguidos, a navegação no projeto será afetada, e algumas funcionalidades não estarão disponíveis.

## Executando o Projeto Java
Siga os passos abaixo para compilar e executar a aplicação:

Clone este repositório para a sua máquina ou faça o download do código-fonte.
Abra o terminal ou prompt de comando e navegue até o diretório onde o projeto foi clonado/baixado.
Compile o código-fonte:
```
javac -encoding ISO-8859-1 Main.java
```
Execute o programa:
```
java Main
```
A aplicação será iniciada, e você poderá utilizar as funcionalidades disponíveis através da interface gráfica.
Considerações Finais
Nossa aplicação de banco em Java foi desenvolvida como um projeto acadêmico, com o objetivo de facilitar a gestão de dados e operações bancárias de forma simples e intuitiva. Lembre-se de seguir as observações importantes para o correto funcionamento da aplicação e garantir que todas as funcionalidades estejam disponíveis.
