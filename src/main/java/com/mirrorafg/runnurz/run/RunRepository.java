package com.mirrorafg.runnurz.run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class RunRepository {

    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("select * from Run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("select id, title, started_on, complated_on, miles, location from Run where id = :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public void create(Run run) {
        var updated = jdbcClient
                .sql("insert into Run (id, title, started_on, complated_on, miles, location) VALUES (?,?,?,?,?,?)")
                .params(
                        List.of(run.id(), run.title(), run.startedOn(), run.complatedOn(), run.miles(), run.location().toString()))
                .update();
        Assert.state(updated == 1, "Field to create run" + run.title());
    }

    public void update(Run run, Integer id) {
        var updated = jdbcClient.sql("update Run set title = ?, started_on=?, complated_on=?, miles=?, location=? where id = ?")
                .params(List.of(run.title(), run.startedOn(), run.complatedOn(), run.miles(), run.location().toString(), id))
                .update();

        Assert.state(updated == 1, "Field to update run" + run.title());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from Run where id=:id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Field to delete Run id: " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from Run").query().listOfRows().size();
    }

    public void saveAll(List<Run> run) {
        run.stream().forEach(this::create);
    }

    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("select * from Run where location = :location").param("location", location)
                .query(Run.class).list();
    }

}
