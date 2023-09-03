package org.example.app.services.positions;

import org.example.app.entities.Position;
import org.example.app.repositories.positions.PositionReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PositionReadService {

    PositionReadRepository repository;

    public PositionReadService(PositionReadRepository repository) {
        this.repository = repository;
    }

    public String readPositions() {

        List<Position> list = repository.readPositions();

        if (list != null) {
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((prop) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(prop.getId())
                                .append(", ")
                                .append(prop.getName())
                                .append("\n")
                );
                return "\n_ Positions ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
