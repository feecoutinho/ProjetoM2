# 🚀 Projeto final - Modulo 02 DevInHouse - Tuma Clamed V2.

## 📋 Medication Management - DevInPharmacy

Tabela de conteúdos
=================
<!--ts-->
   * [**Sobre**](#Sobre)
   * [**Tecnologias**](#Tecnologias)
   * [**Como usar**](#Rodandooprojetonoservidor)
   * [**Features**](#Features)
   * [**Próximos Passos**](#ProximosPassos)
  
<!--te-->

### Sobre:

O presente trabalho é uma atividade desenvolvida durante o módulo de back-end do curso DevInHouse, Turma Clamed V2, executado com uso do framework SPRING BOOT. 
Medication Management é uma API REST voltada para o gerenciamento interno de farmácias, seus estoques e medicamentos. O sistema disponibiliza
Este repositório contém o código fonte da API REST projetada para demonstrar os conceitos e funcionalidades solicitados no projeto. Cada branch contém o código fonte do respectivo resquisito funcional.

#### Pré-requisitos:
O projeto é desenvolvido com Maven, Java 17 e Spring Boot 3.2.0. 
Para rodar a aplicação é necessário a instalação do Java 17 (ou posterior) e também do PostgreSQL na máquina.

### Tecnologias 🛠

As seguintes ferramentas foram usadas na construção do projeto:

- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [Maven](https://maven.apache.org/)
- [Lombok](https://projectlombok.org/)
- [ModelMapper](https://modelmapper.org/)

### Rodando o projeto no servidor ⚙️ 

```shell
# Clone este repositório
$ git clone <https://github.com/feecoutinho/ProjetoM2>
```
```shell
# Acesse a pasta raiz do projeto no terminal e digite os comandos a seguir:

./mvnw clean package

./mvnw spring-boot:run

```
### Métodos

Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

### Respostas

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (200 OK).|
| `201` | Registro criado com sucesso (201 CREATED).|
| `400` | Solicitação com erros de validação ou os campos informados inexistentes no sistema (400 BAD REQUEST).|
| `404` | Registro não encontrado (404 NOT FOUND).|


### Features 📄

A seguir estão listados os requisitos funcionais do projeto, bem como um  breve trecho do código desenvolvido para executar cada requisito.
Para ver o código, seus métodos e funções na totalidade, acesse os arquivos dentro do repositório.


- [x] RF01 - Carga inicial de dados
```shell
Serviço responsável por popular os dados inicias nas tabelas.
```
|  |  |
|---|---|
| `Endpoint:` | HTTP POST ⇒ /inicializacao |
| `Request:`  | Sem request body ou parâmetros |
| `Response:` | HTTP 200 OK |

- [x] RF02 - Consulta de Farmácias
~~~~Java
    public List<Farmacia> consultar() {
        return farmaciaRepo.findAll();
    }
~~~~

- [x] RF03 - Consulta de Farmácia pelo CNPJ
~~~~Java
      public Farmacia consultar(Long cnpj) {
        return farmaciaRepo.findById(cnpj)
        .orElseThrow(() -> new RegistroNaoEncontradoException("Farmacia", cnpj));
    }
~~~~

- [x] RF04 - Inclusão de Farmácia
~~~~Java
       public boolean checaSeExiste(Long cnpj) {
        return farmaciaRepo.existsById(cnpj);
    }

      public Farmacia salvar(@NotNull Farmacia farmacia) {
        boolean existe = farmaciaRepo.existsById(farmacia.getCnpj());
        if (existe)
            throw new RegistroJaCadastradoException("Farmacia", farmacia.getCnpj());
        farmacia = farmaciaRepo.save(farmacia);
        return farmacia;
    }
~~~~

- [x] RF05 - Consulta de Medicamentos
~~~~Java
      public Medicamento consultar(Integer Nro) {
        return medRepo.findById(Nro)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Medicamento", Nro));
    }
~~~~

- [x] RF06 - Inclusão de Medicamento
~~~~Java
      public boolean checaSeExiste(Integer Nro) {
        return medRepo.existsById(Nro);
    }

    public Medicamento salvar(Medicamento medicamento) {
        boolean existe = medRepo.existsById(medicamento.getNroRegistro());

        medicamento = medRepo.save(medicamento);
        return medicamento;
    }
~~~~

- [x] RF07 - Consulta de Estoque de Farmácia
~~~~Java
    public List<Estoque> consultar(Long cnpj) {
        Farmacia farma = farmaciaService.consultar(cnpj);
        return estoqueRepo.findAllByFarmacia(farma);
    }
~~~~

- [x] RF08 - Aquisição de Medicamentos para Estoque de farmácia
~~~~Java
    public Estoque adquirirEstoque(Long cnpj, Integer nroRegistro, Integer qty, LocalDateTime data) {
        Farmacia farma = farmaciaService.consultar(cnpj);
        Medicamento med = medicamentoService.consultar(nroRegistro);
        if (qty <= 0){
            throw new QuantidadeInvalidaException(qty);
        }
~~~~

- [x] RF09 - Venda de Medicamentos com atualização do Estoque de farmácia
~~~~Java
    public Estoque venderEstoque(Long cnpj, Integer nroRegistro, Integer qty, LocalDateTime data) {
        Farmacia farma = farmaciaService.consultar(cnpj);
        Medicamento med = medicamentoService.consultar(nroRegistro);
        if (qty <= 0){
            throw new QuantidadeInvalidaException(qty);
        }
~~~~

- [x] RF10 -Troca de Medicamentos entre Estoques de Farmácias

~~~~Java
    public List<Estoque> trocaEstoque(Long cnpjOrigem, Long cnpjDestino, Integer nroRegistro, Integer qty, LocalDateTime data) {
       
        farmaciaService.consultar(cnpjOrigem);
        farmaciaService.consultar(cnpjDestino);
        medicamentoService.consultar(nroRegistro);
      
        Estoque EstoqueOrigem = venderEstoque(cnpjOrigem, nroRegistro, qty, data);
        Estoque EstoqueDestino = adquirirEstoque(cnpjDestino, nroRegistro, qty, data);
        return Arrays.asList(EstoqueOrigem, EstoqueDestino);
    }
~~~~

### Próximos Passos 💭
Este foi minha primeira tentativa de desenvolver uma API REST, revisitarei o código após a avaliação do curso para estudar maneiras de aperfeiçoar o trabalho e pretendo implementar algumas funcionalidades extras, como uma página web ou aplicativo com formulários para executar as requisições e garantir uma maior facilidade de uso para os usuários e a criação de um alerta que avise ao usuário quando o estoque de um medicamento for zerado.

