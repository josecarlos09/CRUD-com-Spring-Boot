# Descrição do projeto: 

A aplicação está organizada em uma arquitetura modular com camadas bem definidas, que são: Models, Controllers, Repositorys, Services, DTOs, Migrations, Configs e SpringDoc Essa estrutura permite realizar operações de CRUD (Create, Read, Update, Delete) via endpoints, garantindo uma separação clara de responsabilidades e facilitando a manutenção e escalabilidade. Abaixo, está descrito o papel de cada camada: 

# Organização do projeto
__Model:__  Define as entidades que representam as tabelas do banco de dados, utilizando anotações JPA para configurar chaves primárias, relacionamentos e restrições. 

 

__Repository:__ Responsável pela persistência de dados, com métodos que acessam e manipulam o banco de dados, geralmente estendendo JpaRepository para simplificar a implementação de operações CRUD. 


 __Service:__ Contém a lógica de negócio, chamando métodos do repositório para realizar operações nos dados e processando-os conforme necessário antes de retorná-los ao controlador. 
 

__Controller:__ Gerencia as requisições HTTP e direciona para os métodos de serviço apropriados, interagindo com o cliente através dos DTOs. 


__DTOs:__ Facilitam o transporte de dados de forma segura e padronizada entre o cliente e o servidor, permitindo o uso de apenas os dados necessários para cada operação. 

 

__Migration:__  Cada migration é identificada por um número de versão único, garantindo que a ordem e o estado do banco de dados sejam corretos. 

 

__Configs:__  Essa camada irar tratar das configurações essenciais para a aplicação, não confunda com o arquivo .properties, essa estruturação não está tratando das configurações que o arquivo . properties trata, mas está trazendo uma melhor estruturação e organização para o projeto trabalhando nas configurações gerais da aplicação. 

 

__Spring Doc:__  integrando-se diretamente com o Spring para documentar endpoints e esquemas de dados sem a necessidade de muita configuração adicional. 

A aplicação utiliza o MySQL como sistema de gerenciamento de banco de dados (SGBD), permitindo uma conexão robusta e eficiente para o armazenamento e recuperação dos dados. Essa estrutura modular promove um desenvolvimento mais organizado, com cada camada focada em uma responsabilidade específica, garantindo que o sistema seja escalável e fácil de manter. 

 
