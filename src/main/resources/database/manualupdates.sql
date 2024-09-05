CREATE INDEX idx_nome ON pessoa (nome);
update pessoa set nome = concat(trim(nome) ,' ', trim(sobrenome)) where id > 0;

OPTIMIZE TABLE pessoa;