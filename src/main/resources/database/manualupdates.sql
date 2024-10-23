
update pessoa set nome = concat(trim(nome) ,' ', trim(sobrenome)) where id > 0;


-- Índices na tabela `pessoa`
-- Verificar e remover índices existentes antes de criar novos índices

-- Índices na tabela `pessoa`
DROP INDEX idx_nome ON pessoa;
CREATE INDEX idx_nome ON pessoa (nome);
OPTIMIZE TABLE pessoa;

DROP INDEX idx_pessoa_id ON pessoa;
CREATE INDEX idx_pessoa_id ON pessoa(id);
OPTIMIZE TABLE pessoa;

-- Índices na tabela `conta`
DROP INDEX idx_conta_id ON conta;
CREATE INDEX idx_conta_id ON conta(id);
OPTIMIZE TABLE conta;

DROP INDEX idx_conta_dataReferente ON conta;
CREATE INDEX idx_conta_dataReferente ON conta(dataReferente);
OPTIMIZE TABLE conta;

DROP INDEX idx_conta_dataPag ON conta;
CREATE INDEX idx_conta_dataPag ON conta(dataPag);
OPTIMIZE TABLE conta;

DROP INDEX idx_conta_dataVence ON conta;
CREATE INDEX idx_conta_dataVence ON conta(dataVence);
OPTIMIZE TABLE conta;

DROP INDEX idx_search_conditions ON conta;
CREATE INDEX idx_search_conditions ON conta(dataReferente, dataPag, idEnderecoPessoa);
OPTIMIZE TABLE conta;

DROP INDEX idx_ordering_conditions ON conta;
CREATE INDEX idx_ordering_conditions ON conta(dataReferente, idEnderecoPessoa);
OPTIMIZE TABLE conta;

-- Índices na tabela `hidrometro`
DROP INDEX idx_hidrometro_idConta ON hidrometro;
CREATE INDEX idx_hidrometro_idConta ON hidrometro(idConta);
OPTIMIZE TABLE hidrometro;

-- Índices na tabela `enderecopessoa`
DROP INDEX idx_enderecopessoa_idEnderecoPessoa ON enderecopessoa;
CREATE INDEX idx_enderecopessoa_idEnderecoPessoa ON enderecopessoa(id);
OPTIMIZE TABLE enderecopessoa;

DROP INDEX idx_enderecopessoa_idPessoa ON enderecopessoa;
CREATE INDEX idx_enderecopessoa_idPessoa ON enderecopessoa(idPessoa);
OPTIMIZE TABLE enderecopessoa;

DROP INDEX idx_enderecopessoa_idCategoriaSocio ON enderecopessoa;
CREATE INDEX idx_enderecopessoa_idCategoriaSocio ON enderecopessoa(idCategoriaSocio);
OPTIMIZE TABLE enderecopessoa;

DROP INDEX idx_enderecopessoa_idEndereco ON enderecopessoa;
CREATE INDEX idx_enderecopessoa_idEndereco ON enderecopessoa(idEndereco);
OPTIMIZE TABLE enderecopessoa;

DROP INDEX idx_data_referente ON conta;
CREATE INDEX idx_data_referente ON conta(dataReferente);

DROP INDEX idx_categoria_nome on categoriasocio;
CREATE INDEX idx_categoria_nome ON categoriasocio(nome);
OPTIMIZE TABLE categoriasocio;

alter table pessoa drop column sobrenome;
alter table pessoa drop column sexo;
alter table pessoa drop column cidade;
alter table pessoa drop column uf;
ALTER TABLE pessoa DROP FOREIGN KEY FKC4E40FA7F1E3C984;
alter table pessoa drop column idEndereco;

ALTER TABLE `acal`.`pessoa`
ADD COLUMN `partner_number` VARCHAR(45) NULL AFTER `cnpj`;

ALTER TABLE `acal`.`pessoa`
ADD COLUMN `created_at` DATE NULL AFTER `partner_number`;


UPDATE `acal`.`endereco` SET `nome` = trim(`nome`) WHERE (`id` > 0);