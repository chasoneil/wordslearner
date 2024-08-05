package com.chason.service;

import com.chason.connect.JDBCUtils;
import com.chason.entity.EnglishWord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WordsService {

    private Connection connection;

    public WordsService () {
        connection = JDBCUtils.connect();
    }

    /**
     * get all
     * @return
     */
    public List<EnglishWord> listByLesson(int lesson) {

        List<EnglishWord> words  = new ArrayList<>();

        if (connection == null) {
            return words;
        }

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select id, word, zh, type, lesson from t_eng_words where lesson = " + lesson);
            while (rs.next()) {
                words.add(convert(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return words;
    }

    private EnglishWord convert (ResultSet resultSet) throws SQLException {

        EnglishWord word = new EnglishWord();
        word.setId(resultSet.getInt("id"));
        word.setWord(resultSet.getString("word"));
        word.setType(resultSet.getInt("type"));
        word.setLesson(resultSet.getInt("lesson"));
        word.setZh(resultSet.getString("zh"));
        return word;
    }

}
