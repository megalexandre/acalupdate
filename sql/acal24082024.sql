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
