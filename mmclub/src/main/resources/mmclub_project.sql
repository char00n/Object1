DROP TABLE IF EXISTS mmc_character;
DROP TABLE IF EXISTS mmc_users;

CREATE TABLE mmc_users
(
    user_id SERIAL,
    user_login varchar(32) not null,
    user_pass varchar(32),
    user_sessionID integer,
    user_email varchar(64) not null,
    user_security_answer varchar(30),
    user_full_name varchar(50),
    user_birth_Day date not null,
    user_gender varchar(1),
    user_city varchar(32),
    user_icq_number varchar(16),
    PRIMARY KEY (user_id)
);

CREATE TABLE mmc_character
(
    char_id SERIAL,
    char_user_id integer not null,
    char_name varchar(32) not null,              /* [MAIN] */
    char_birth_day date not null,                /* [MAIN] */
    char_gender varchar(1),                      /* [MAIN] */
    char_image varchar(30) DEFAULT 'DEFF1',      /* [MAIN] изображения перса*/
    char_stat_strength integer DEFAULT 3,        /* [STAT] сила персонажа */
    char_stat_strength_total integer DEFAULT 3,  /* [STAT] сила персонажа c учетом вещей */
    char_stat_endurance integer DEFAULT 3,       /* [STAT] Выносливость (Здоровье=Выносливость*5) */
    char_stat_endurance_total integer DEFAULT 3, /* [-STAT-] Выносливость (Здоровье=Выносливость*5) */
    char_stat_accuracy integer DEFAULT 3,        /* [STAT] Точность перса (влияет на крит.удар) */
    char_stat_accuracy_total integer DEFAULT 0,  /* [STAT] Точность с уч. вещей перса */
    char_stat_dexterity integer DEFAULT 3,       /* [STAT] Ловкость перса (влияет на уворот) */
    char_stat_dexterity_total integer DEFAULT 0, /* [STAT] Ловкость перса с уч. вещей */
    char_stat_cur_health integer DEFAULT 0,      /* [STAT] тек здоровье во время боя */
    char_stat_max_health integer DEFAULT 20,     /* [STAT] Максимальное здоровье с учетом вещей */
    char_stat_unused_points integer DEFAULT 3,   /* [STAT] Неиспользованные очки для распределения в статы (сила, ловкость....) */
    char_skill_sword integer DEFAULT 0,          /* [SKILL] Мастерство владения мечом*/
    char_skill_spear integer DEFAULT 0,          /* [SKILL] Мастерство владения копьем*/
    char_skill_axe integer DEFAULT 0,            /* [SKILL] Мастерство владения Топором*/
    char_skill_mace integer DEFAULT 0,           /* [SKILL] Мастерство владения Молот,Дубина*/
    char_skill_dagger integer DEFAULT 0,         /* [SKILL] Мастерство владения Ножом*/
    char_exp_level integer DEFAULT 0,            /* [EXP] УРОВЕНЬ ИГРОКА*/
    char_exp_cur_exp integer DEFAULT 0,          /* [EXP] ОПЫТ ИГРОКА*/
    char_exp_next_exp integer DEFAULT 10,        /* [EXP] Следующая граничная точка опыта*/
    char_stuff_money integer DEFAULT 200,        /* [STUFF] деньги*/
    char_stuff_max_weigth integer DEFAULT 20,    /* [STUFF] максимальный вес предметов в рюкзаке*/
    char_slot_helmet integer DEFAULT 0,          /* [SLOT] слот шлема*/
    char_slot_shield integer DEFAULT 0,          /* [SLOT] слот щита*/
    char_slot_weapon integer DEFAULT 0,          /* [SLOT] слот оружия*/
    char_slot_gloves integer DEFAULT 0,          /* [SLOT] слот перчаток*/
    char_slot_shoes integer DEFAULT 0,           /* [SLOT] слот обуви*/
    char_slot_armor integer DEFAULT 0,           /* [SLOT] слот брони*/
    char_slot_necklace integer DEFAULT 0,        /* [SLOT] слот ожерелья*/
    char_slot_ring1 integer DEFAULT 0,           /* [SLOT] слот 1 кольца*/
    char_slot_ring2 integer DEFAULT 0,           /* [SLOT] слот 2 кольца*/
    char_slot_ring3 integer DEFAULT 0,           /* [SLOT] слот 3 кольца*/
    char_slot_ring4 integer DEFAULT 0,           /* [SLOT] слот 4 кольца*/
    char_slot_ear integer DEFAULT 0,             /* [SLOT] слот серег*/
    char_slot_belt integer DEFAULT 0,            /* [SLOT] слот пояса*/
    char_town integer DEFAULT 0, /*Текущий город перса*/
    char_building integer DEFAULT 0, /*текущее положение перса в городе (здание, площадь)*/
    char_moving_type integer DEFAULT 0, /*текущее транспортное средство (корабль, карета)*/
    char_end_moving_time date DEFAULT 'Now' NOT NULL, /*время прибытия в Пункт Назначения*/
    char_disposition integer DEFAULT 0, /*склонность перса*/
    char_clan integer DEFAULT 0, /*клан перса*/
    PRIMARY KEY (char_id),
    FOREIGN KEY (char_user_id) REFERENCES mmc_users(user_id) ON DELETE RESTRICT
);