
# Viva Imóveis

Bem-vindo ao projeto **Viva Imóveis**, uma plataforma de gestão de imóveis, onde é possível cadastrar, gerenciar e visualizar propriedades, usuários e suas funções (administrador, gerente, usuário comum). O sistema oferece funcionalidades de cadastro de usuários, login, e o gerenciamento de propriedades, tudo de forma simples e intuitiva.

## Tecnologias Utilizadas

- **Backend**:
  - **Spring Boot**: Framework para desenvolvimento da aplicação backend.
  - **Spring Security**: Para autenticação e controle de acesso.
  - **Spring Data JPA**: Para comunicação com o banco de dados usando Hibernate.
  - **MySQL**: Banco de dados relacional para persistência de dados.

- **Frontend**:
  - **Thymeleaf**: Motor de templates para renderização do frontend.
  - **CSS** (customizado e Font Awesome para ícones).

## Funcionalidades

### Cadastro e Login
- Usuários podem se cadastrar no sistema e fazer login utilizando nome de usuário e senha.
- Funcionalidade de recuperação de senha pode ser implementada, caso necessário.

### Gerenciamento de Imóveis
- Usuários podem cadastrar novos imóveis, editá-los ou removê-los, caso tenha permissão.
- Cada imóvel pode ter informações como: nome, descrição, valor, fotos, etc.

### Gestão de Usuários
- Cada usuário possui um papel (Role) atribuído: **Administrador**, **Gerente**, **Usuário**.
- **Administrador**: Tem permissão total sobre a plataforma, podendo cadastrar e editar usuários, imóveis, e visualizar relatórios.
- **Gerente**: Pode cadastrar e gerenciar imóveis, mas não pode alterar usuários.
- **Usuário**: Acesso limitado, apenas visualiza os imóveis cadastrados.

### Proteção de Recursos
- **Spring Security**: Restrições de acesso baseadas nos papéis dos usuários, com permissões distintas para Administradores, Gerentes e Usuários.

## Estrutura do Projeto

A estrutura do projeto segue o padrão utilizado pelo **Spring Boot** para organizar os componentes da aplicação:

```
src/
  ├── main/
  │   ├── java/
  │   │   ├── com/vivaimoveis/imobiliaria/
  │   │   │   ├── controller/          # Controladores (Controllers)
  │   │   │   ├── core/
  │   │   │   │   ├── entity/           # Entidades (Entities) como User, UserRole, etc.
  │   │   │   │   ├── repository/       # Repositórios para acesso ao banco de dados
  │   │   │   │   ├── service/          # Lógica de negócio (Services)
  │   │   │   ├── config/               # Configurações do Spring Security e outras
  │   │   ├── resources/
  │   │   │   ├── static/               # Arquivos estáticos (CSS, JS, imagens)
  │   │   │   ├── templates/            # Templates Thymeleaf (HTML)
  │   │   │   ├── application.properties # Configurações da aplicação
```

## Como Rodar o Projeto

### 1. Requisitos
- Java 11 ou superior.
- MySQL ou qualquer banco de dados relacional compatível.
- Maven ou Gradle (dependendo de como o projeto foi configurado).

### 2. Configuração do Banco de Dados
Certifique-se de que o banco de dados MySQL está configurado corretamente.

1. Crie um banco de dados chamado `vivaimoveis`.
2. Defina o usuário e a senha para acessar o banco de dados.

Exemplo de configuração do `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vivaimoveis
spring.datasource.username=root
spring.datasource.password=suasenha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### 3. Build e Execução
1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/viva-imoveis.git
```

2. Acesse a pasta do projeto:

```bash
cd viva-imoveis
```

3. Se estiver usando Maven, rode o comando:

```bash
mvn spring-boot:run
```


### 4. Acessando o Sistema
Depois que o sistema for iniciado, abra seu navegador e acesse a URL:

```
http://localhost:8080
```

## Endpoints da API

A aplicação possui os seguintes endpoints principais:

- **GET /cadastro**: Exibe o formulário de cadastro de usuário.
- **POST /cadastro**: Processa o cadastro de um novo usuário.
- **GET /login**: Exibe o formulário de login.
- **POST /login**: Processa a autenticação do usuário.
- **GET /visitas/novo**: Formulário para agendar visita.
- **POST /visitas**: Salva nova visita.
- **GET /visitas**: Lista de visitas agendadas.
- **GET /imovel/comprar**: Imóveis para venda.
- **GET /imovel/alugar**: Imóveis para aluguel.
- **GET /imovel/detalhes/{id}**: Detalhes de um imóvel.
- **GET /imovel**: Lista de imóveis.
- **GET /imovel/novo**: Formulário para cadastrar imóvel.
- **POST /imovel**: Salva novo imóvel.
- **GET /imovel/{id}/editar**: Formulário para editar imóvel.
- **POST /imovel/{id}/editar**: Atualiza imóvel.
- **GET /imovel/{id}/excluir**: Exclui imóvel.
- **GET /sobre**: Página sobre a empresa.
- **GET /contato**: Página de contato.
- **GET /administrativo**: Painel administrativo.

## Licença

Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

Esse `README.md` fornece uma visão geral do projeto, explica como configurar e rodar a aplicação, e fornece detalhes sobre as principais funcionalidades e como contribuir para o projeto. Se houver algo mais específico que você queira adicionar ou modificar, fique à vontade para ajustar conforme necessário.
