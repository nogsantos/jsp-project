BEGIN transaction;
create table pessoa (
  codigo_pessoa varchar(15)
  , nome  varchar(250) not null
  , logradouro varchar(550)
  , email varchar(250) unique
  , telefone varchar(10)
  , constraint pessoa_codigo_pk primary key (codigo_pessoa)
);

create table usuario(
  codigo_pessoa varchar(15)
  , login varchar(30) not null
  , senha varchar(45) not null
  , constraint usuario_codigo_pessoa_pk primary key (codigo_pessoa)
  , constraint usuario_fk 
        foreign key (codigo_pessoa) references pessoa (codigo_pessoa)
);

create table perfil(
  codigo_perfil bigserial
  , nome varchar(250) not null
  , descricao varchar(550)
  , constraint perfil_codigo_perfil_pk primary key (codigo_perfil)
);

create table usuario_perfil(
  codigo_pessoa varchar(15)
  , codigo_perfil int
  , constraint usuario_perfil_pk primary key (codigo_pessoa, codigo_perfil)
  , constraint usuario_perfil_pessoa_fk 
        foreign key (codigo_pessoa) references pessoa (codigo_pessoa)        
  , constraint usuario_perfil_perfil_fk 
        foreign key (codigo_perfil) references perfil (codigo_perfil)
);

create table modulo(
  codigo_modulo bigserial
  , nome varchar(250) not null
  , descricao varchar(550)
  , ordem int
  , constraint modulo_pk primary key (codigo_modulo)
);

create table formulario(
  codigo_formulario bigserial
  , codigo_modulo int not null 
  , nome varchar(250) not null
  , nome_menu varchar(20) not null
  , descricao varchar(550)
  , ordem int
  , flag_oculto char(1) 
  , constraint formulario_pk primary key (codigo_formulario)
  , constraint formulario_modulo_fk 
        foreign key (codigo_modulo) references modulo (codigo_modulo)
);

create table funcao(
  codigo_funcao bigserial
  , codigo_formulario int not null
  , nome varchar(250) not null
  , descricao varchar(550)
  , constraint funcao_pk primary key (codigo_funcao)
  , constraint funcao_formulario_fk 
        foreign key (codigo_formulario) references formulario (codigo_formulario)
);

create table permissao(
  codigo_perfil bigserial
  , codigo_modulo int
  , codigo_formulario int
  , codigo_funcao int
  , constraint permissao_perfil_fk 
        foreign key (codigo_perfil) references perfil (codigo_perfil)
  , constraint permissao_modulo_fk 
        foreign key (codigo_modulo) references modulo (codigo_modulo)
  , constraint permissao_formulario_fk 
        foreign key (codigo_formulario) references formulario (codigo_formulario)
  , constraint permissao_funcao_fk 
        foreign key (codigo_funcao) references funcao (codigo_funcao)
);
comment on table pessoa is 'Entidade Principal para o cadastro de pessoas no sistema.';
comment on column pessoa.nome is 'Nome pessoa';
comment on column pessoa.logradouro is 'Endereco pessoa';
comment on column pessoa.email is 'Um email por pessoa';
comment on column pessoa.telefone is 'Telefone pessoa';
comment on column pessoa.data_nascimento is 'Data nascimento pessoa';

comment on table usuario is 'Especialização de pessoa, define o cadastro de usuários do sistema.';
comment on column usuario.login is 'Login do usuário no sistema.';
comment on column usuario.senha is 'Senha de acesso ao sistema, preve-se utilizar criptografia para o cadastro';

comment on table perfil is 'Entidade de definição de acesso ao sistema através da criação de perfis, com a finalidade de se agrupar os usuários';
comment on column perfil.nome is 'Nome perfil';
comment on column perfil.descricao is 'Descrição detalhada sobre o perfil';

comment on table usuario_perfil is 'Usuários podem exercer mais de um perfil no sistema';

comment on table modulo is 'Permite o cadastro de módulos no sistema';
comment on column modulo.nome is 'Nome modulo';
comment on column modulo.descricao is 'Descricao detalhada sobre o modulo';
comment on column modulo.ordem is 'Ordenação para apresentação no menu, quando montado dinamicamente';

comment on table formulario is 'Permite o cadastro de formulários vinculados aos módulos';
comment on column formulario.nome is 'Nome formulario';
comment on column formulario.nome_menu is 'Nome que será apresentado no menu';
comment on column formulario.descricao is 'Descrição detalhada sobre o formulario';
comment on column formulario.ordem is 'Ordenação para apresentação no menu, quando montado dinamicamente';
comment on column formulario.flag_oculto is 'Booleano para definir se o formulário em questão estará disponível para o usuário ou será apenas para ações específicas(Y/N)';

comment on table funcao is 'Permite o cadastro de funções vinculadas aos fomrmulários';
comment on column funcao.nome is 'Nome função';
comment on column funcao.descricao is 'Descrição detalhada sobre a função';

comment on table permissao is 'Permite o cadastro de permissões no sistema por perfil, é importante ressaltar que é necessário seguir a hierarquia onde a função depende do formulario que consequentemente depende do módulo para existir.';

insert into perfil(nome, descricao) values('Nome modelo', 'descrição modelo');
insert into modulo(nome, descricao, ordem) values('Nome modelo', 'descrição modelo',0);
insert into formulario(codigo_modulo, nome, nome_menu, descricao, ordem, flag_oculto) values(1, 'Nome modelo', 'Nome menu modelo' ,'descrição modelo',0, 'f');
insert into funcao(codigo_formulario, nome, descricao) values(1, 'Nome modelo', 'descrição modelo');
commit;

