

DROP Database rh ;
CREATE Database rh;
USE rh ;


CREATE TABLE Servidor (
  MatriculaSiape             VARCHAR(7) Not Null,
  Nome                       VARCHAR(100),
  NomeMae                    VARCHAR(100),
  NomePai                    VARCHAR(100),
  Senha                      VARCHAR(100),
  Email                      VARCHAR(100),
  Perfil                     VARCHAR(100),
  Sexo                       Boolean,
  DataNascimento             DATE,
  Naturalidade               VARCHAR(100),
  NatUf                      VARCHAR(2),
  Nacionalidade              VARCHAR(100),
  Escolaridade               VARCHAR(100),
  EstadoCivil                VARCHAR(100),
  TipoSanguineo              VARCHAR(2),
  FatorRH                    VARCHAR(5),
  CPF                        VARCHAR(11),
  RG                         VARCHAR(15),
  RgOrgaoExpedidor           VARCHAR(10),
  RgUf                       VARCHAR(2),
  DataExpedicao              DATE,
  TituloEleitor              VARCHAR(15),
  TeUF                       VARCHAR(2),
  Zona                       VARCHAR(100),
  Sessao                     VARCHAR(100),
  DataEmissao                DATE,
  DocumentoMilitar           VARCHAR(100),
  CamOrgaoExpedidor          VARCHAR(10),
  CamSerie                   VARCHAR(100),
  CarteiraTrabalho           VARCHAR(100),
  CtpsSerie                  VARCHAR(100),
  CtpsUF                     VARCHAR(100),
  PisPasep                   VARCHAR(100),
  DataPrimeiroEmprego        VARCHAR(100),
  Endereco                   VARCHAR(100),
  NumeroComplemento          VARCHAR(100),
  Bairro                     VARCHAR(100),
  CEP                        VARCHAR(9),
  Cidade                     VARCHAR(100),
  Estado                     VARCHAR(100),
  TelefoneResidencial        VARCHAR(100),
  TelefoneCelular            VARCHAR(100),
  Banco                      VARCHAR(100),
  Agencia                    VARCHAR(100),
  Numero                     VARCHAR(100),
  Status                     VARCHAR(100),
  FormacaoExcedente          VARCHAR(100),
  FormacaoExcedente2         VARCHAR(100),
  InformacoessComplementares VARCHAR(100),
  PRIMARY KEY (MatriculaSiape),
  UNIQUE INDEX MatriculaSiape_UNIQUE (MatriculaSiape ASC)
);



CREATE TABLE Setor (
  Id          integer auto_increment NOT NULL,
  Nome        VARCHAR(100),
  Responsavel VARCHAR(100),
  Descricao   VARCHAR(100),
  Email       VARCHAR(100),
  IdSetor     integer NULL,
  PRIMARY KEY (Id),
  UNIQUE INDEX Id_UNIQUE (Id ASC),
  INDEX fk_setor_setor1_idx (IdSetor ASC),
  CONSTRAINT fk_setor_setor1 FOREIGN KEY (IdSetor) REFERENCES Setor (Id)
);



CREATE TABLE SetorServidor (
  setor_Id                integer   NOT NULL,
  servidor_MatriculaSiape VARCHAR(7) NOT NULL, 
  PRIMARY KEY (setor_Id, servidor_MatriculaSiape),
  INDEX fk_setor_has_servidor_servidor1_idx (servidor_MatriculaSiape ASC),
  INDEX fk_setor_has_servidor_setor_idx (setor_Id ASC),
  CONSTRAINT fk_setor_has_servidor_setor      FOREIGN KEY (setor_Id)                REFERENCES Setor (Id),    
  CONSTRAINT fk_setor_has_servidor_servidor1  FOREIGN KEY (servidor_MatriculaSiape) REFERENCES Servidor (MatriculaSiape)
);
