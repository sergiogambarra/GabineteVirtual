drop database RH;
create database RH;
use RH;


create table Servidor( 
    MatriculaSIAPE PRIMARY KEY NOT NULL varchar(007),
    Nome                                varchar(100),
    Setor                               integer     ,
    NomeMãe                             varchar(100),
    NomePai                             varchar(100),
    Senha                               varchar(100),
    Email                               varchar(100),
    Perfil                              varchar(100),
    Sexo                                Boolean     ,
    DataNascimento                      Date        ,
    Naturalidade                        varchar(100),
    NatUf                               varchar(002),
    Nacionalidade                       varchar(100),
    Escolaridade                        varchar(100),
    EstadoCivil                         varchar(100),
    TipoSanguíneo                       varchar(002),
    FatorRH                             varchar(005),
    CPF                                 varchar(011),
    RG                                  varchar(015),
    RgOrgaoExpedidor                    varchar(010),
    RgUf                                varchar(002),
    DataExpedicao                       Date        ,
    TituloEleitor                       varchar(015),
    TeUF                                varchar(002),
    Zona                                varchar(100),
    Sessao                              varchar(100),
    DataEmissao                         Date        ,
    DocumentoMilitar                    varchar(100),
    CamOrgaoExpedidor                   varchar(010),
    CamSerie                            varchar(100),
    CarteiraTrabalho                    varchar(100),
    CtpsSerie                           varchar(100),
    CtpsUF                              varchar(100),
    PisPasep                            varchar(100),
    DataPrimeiroEmprego                 varchar(100),
    Endereco                            varchar(100),
    NumeroComplemento                   varchar(100),
    Bairro                              varchar(100),
    CEP                                 varchar(009),
    Cidade                              varchar(100),
    Estado                              varchar(100),
    TelefoneResidencial                 varchar(100),
    TelefoneCelular                     varchar(100),
    Banco                               varchar(100),
    Agencia                             varchar(100),
    Numero                              varchar(100),
    Status                              varchar(100),
    FormacaoExcedente                   varchar(100),
    FormacaoExcedente2                  varchar(100),
    InformacoessComplementares          varchar(100)
);




drop database GabineteVirtual;
create database GabineteVirtual;
use GabineteVirtual;

