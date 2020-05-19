package ua.object1.mmclub.dao;

import ua.object1.mmclub.domain.character.*;
import ua.object1.mmclub.domain.character.Character;
import ua.object1.mmclub.domain.constants.DbCharacter;
import ua.object1.mmclub.domain.enums.Gender;
import ua.object1.mmclub.domain.register.User;
import ua.object1.mmclub.domain.register.UserRegistration;

import java.sql.*;

public class CharacterDaoImpl implements CharacterDao
{

    private static final String INSERT_CHARACTER_DEF =
        " INSERT INTO mmc_character(char_user_id, char_name, char_birth_day, char_gender ) \n" +
            "    VALUES (?, ?, ?, ?) ";

    private static final String SELECT_CHARACTER =
        "SELECT \n" +
            "    char_name, char_birth_day, char_gender, char_image, \n" +
            "    char_town, char_building, char_moving_type, char_end_moving_time, char_disposition, char_clan, \n" +
            "    char_stat_strength, char_stat_strength_total, \n" +
            "    char_stat_endurance, char_stat_endurance_total, \n" +
            "    char_stat_accuracy, char_stat_accuracy_total, \n" +
            "    char_stat_dexterity, char_stat_dexterity_total, \n" +
            "    char_stat_cur_health, char_stat_max_health, char_stat_unused_points, \n" +
            "    char_skill_sword, char_skill_spear, char_skill_axe, char_skill_mace, char_skill_dagger, \n" +
            "    char_exp_level, char_exp_cur_exp, char_exp_next_exp, \n" +
            "    char_stuff_money, char_stuff_max_weigth, \n" +
            "    char_slot_helmet, char_slot_shield, char_slot_weapon, char_slot_gloves, \n" +
            "    char_slot_shoes, char_slot_armor, char_slot_necklace, \n" +
            "    char_slot_ring1, char_slot_ring2, char_slot_ring3, char_slot_ring4, \n" +
            "    char_slot_ear, char_slot_belt \n" +
            " FROM mmc_character \n" +
            " WHERE char_user_id = ? ";

    @Override
    public Character readCharacter(User user) throws SQLException {

        if (!user.isLogged())
        {
            return null;
        }

        Character character = null;

        try (Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_CHARACTER))
        {
            stmt.setLong(1, user.getUserID());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                character = getCharacter(user, rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return character;
    }

    private Character getCharacter(User user, ResultSet rs) throws SQLException {
        Character character = new Character();

        character.setUser(user);
        character.setName(rs.getString(DbCharacter.NAME));
        character.setBirthDay(rs.getDate(DbCharacter.DT).toLocalDate());
        character.setGender(Gender.fromValue(rs.getString(DbCharacter.GENDER)));
        character.setImage(rs.getString(DbCharacter.IMAGE));
        character.setTown(rs.getInt(DbCharacter.TOWN));
        character.setBuilding(rs.getInt(DbCharacter.BUILDING));
        character.setMovingType(rs.getInt(DbCharacter.MOVING_TYPE));
        character.setEndMovingTime(rs.getTimestamp(DbCharacter.END_MOVING_TIME).toLocalDateTime());
        character.setDisposition(rs.getInt(DbCharacter.DISPOSITION));
        character.setClan(rs.getInt(DbCharacter.CLAN));

        Stat stat = getStat(rs);
        character.setCharStat(stat);

        Skill skill = getSkill(rs);
        character.setCharSkill(skill);

        Experience exp = getExperience(rs);
        character.setCharExp(exp);

        Stuff stuff = getStuff(rs);
        character.setCharStuff(stuff);

        Slot slot = getSlot(rs);
        character.setCharSlot(slot);

        return character;
    }

    private Slot getSlot(ResultSet rs) throws SQLException{
        Slot slot = new Slot();
        slot.setHelmet(rs.getInt(DbCharacter.SLOT_HELMET));
        slot.setShield(rs.getInt(DbCharacter.SLOT_SHIELD));
        slot.setWeapon(rs.getInt(DbCharacter.SLOT_WEAPON));
        slot.setGloves(rs.getInt(DbCharacter.SLOT_GLOVES));
        slot.setShoes(rs.getInt(DbCharacter.SLOT_SHOES));
        slot.setArmor(rs.getInt(DbCharacter.SLOT_ARMOR));
        slot.setNecklace(rs.getInt(DbCharacter.SLOT_NECKLACE));
        slot.setRing1(rs.getInt(DbCharacter.SLOT_RING1));
        slot.setRing2(rs.getInt(DbCharacter.SLOT_RING2));
        slot.setRing3(rs.getInt(DbCharacter.SLOT_RING3));
        slot.setRing4(rs.getInt(DbCharacter.SLOT_RING4));
        slot.setEar(rs.getInt(DbCharacter.SLOT_EAR));
        slot.setBelt(rs.getInt(DbCharacter.SLOT_BELT));

        return slot;
    }

    private Stuff getStuff(ResultSet rs) throws SQLException{
        Stuff stuff = new Stuff();
        stuff.setMoney(rs.getInt(DbCharacter.STUFF_MONEY));
        stuff.setMaxWeigth(rs.getInt(DbCharacter.STUFF_MAX_WEIGTH));

        return stuff;
    }

    private Experience getExperience(ResultSet rs) throws SQLException{
        Experience exp = new Experience();
        exp.setLevel(rs.getInt(DbCharacter.EXP_LEVEL));
        exp.setCurrentExp(rs.getInt(DbCharacter.EXP_CUR_EXP));
        exp.setNextExp(rs.getInt(DbCharacter.EXP_NEXT_EXP));
        return exp;
    }

    private Skill getSkill(ResultSet rs) throws SQLException{
        Skill skill = new Skill();

        skill.setSword(rs.getInt(DbCharacter.SKILL_SWORD));
        skill.setSpear(rs.getInt(DbCharacter.SKILL_SPEAR));
        skill.setAxe(rs.getInt(DbCharacter.SKILL_AXE));
        skill.setMace(rs.getInt(DbCharacter.SKILL_MACE));
        skill.setDagger(rs.getInt(DbCharacter.SKILL_DAGGER));

        return skill;
    }

    private Stat getStat(ResultSet rs) throws SQLException {
        Stat stat = new Stat();
        stat.setStrength(rs.getInt(DbCharacter.STAT_STRENGTH));
        stat.setStrengthTotal(rs.getInt(DbCharacter.STAT_STRENGTH_TOTAL));
        stat.setEndurance(rs.getInt(DbCharacter.STAT_ENDURANCE));
        stat.setEnduranceTotal(rs.getInt(DbCharacter.STAT_ENDURANCE_TOTAL));
        stat.setAccuracy(rs.getInt(DbCharacter.STAT_ACCURACY));
        stat.setAccuracyTotal(rs.getInt(DbCharacter.STAT_ACCURACY_TOTAL));
        stat.setDexterity(rs.getInt(DbCharacter.STAT_DEXTERITY));
        stat.setDexterityTotal(rs.getInt(DbCharacter.STAT_DEXTERITY_TOTAL));
        stat.setCurHealth(rs.getInt(DbCharacter.STAT_CUR_HEALTH));
        stat.setMaxHealth(rs.getInt(DbCharacter.STAT_MAX_HEALTH));
        stat.setUnUsedPoints(rs.getInt(DbCharacter.STAT_UNUSED_POINTS));

        return stat;
    }

    @Override
    public boolean saveCharacter(UserRegistration userRegistration, Long userId) throws SQLException {

        int index = 1;
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_CHARACTER_DEF))
        {
            stmt.setLong(index, userId);
            stmt.setString(++index, userRegistration.getNickName());
            stmt.setDate(++index, java.sql.Date.valueOf(userRegistration.getCharacterBirthDay()));
            stmt.setString(++index, userRegistration.getUserGender().getValue());

            stmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            throw ex;
        }

        return true;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/mmclub",
                "postgres", "Postgres");
    }
}
