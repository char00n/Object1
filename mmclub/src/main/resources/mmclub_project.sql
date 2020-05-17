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
    char_stat_unused_points integer DEFAULT 3,   /* [STAT]Неиспользованные очки для распределения в статы (сила, ловкость....) */
    Character_Sword integer DEFAULT 0, /*Мастерство владения мечом*/
    Character_Spear integer DEFAULT 0, /*Мастерство владения копьем*/
    Character_Axe integer DEFAULT 0, /*Мастерство владения Топором*/
    Character_Mace integer DEFAULT 0, /*Мастерство владения Молот,Дубина*/
    Character_Dagger integer DEFAULT 0, /*Мастерство владения Ножом*/
    Character_Level integer DEFAULT 0, /*УРОВЕНЬ ИГРОКА*/
    Character_Experience integer DEFAULT 0, /*ОПЫТ ИГРОКА*/
    Character_NextExperience integer DEFAULT 10, /*Следующая граничная точка опыта*/
    char_Money integer DEFAULT 200, /*деньги*/
    Town integer DEFAULT 0, /*Текущий город перса*/
    Building integer DEFAULT 0, /*текущее положение перса в городе (здание, площадь)*/
    Moving_Type integer DEFAULT 0, /*текущее транспортное средство (корабль, карета)*/
    EndMoving_Time date DEFAULT 'Now' NOT NULL, /*время прибытия в Пункт Назначения*/
    Character_Disposition integer DEFAULT 0, /*склонность перса*/
    Character_Clan integer DEFAULT 0, /*клан перса*/
    Character_Image CHAR(30) DEFAULT 'standart1.gif', /*изображения перса*/
    Character_MaxWeigth integer DEFAULT 20, /*максимальный вес предметов в рюкзаке*/
    Helmet_Slot integer DEFAULT 0, /*слот шлема*/
    Shield_Slot integer DEFAULT 0, /*слот щита*/
    Weapon_Slot integer DEFAULT 0, /*слот оружия*/
    Gloves_Slot integer DEFAULT 0, /*слот перчаток*/
    Shoes_Slot integer DEFAULT 0, /*слот обуви*/
    Armor_Slot integer DEFAULT 0, /*слот брони*/
    Necklace_Slot integer DEFAULT 0, /*слот ожерелья*/
    Ring1_Slot integer DEFAULT 0, /*слот 1 кольца*/
    Ring2_Slot integer DEFAULT 0, /*слот 2 кольца*/
    Ring3_Slot integer DEFAULT 0, /*слот 3 кольца*/
    Ring4_Slot integer DEFAULT 0, /*слот 4 кольца*/
    Ear_Slot integer DEFAULT 0, /*слот серег*/
    Belt_Slot integer DEFAULT 0, /*слот пояса*/
    PRIMARY KEY (char_id),
    FOREIGN KEY (char_user_id) REFERENCES mmc_users(user_id) ON DELETE RESTRICT
);