package org.example.app.services.positions;

import org.example.app.repositories.positions.PositionDeleteRepository;
import org.example.app.utils.Constants;

public class PositionDeleteService {

    private final PositionDeleteRepository repository;

    public PositionDeleteService(PositionDeleteRepository repository) {
        this.repository = repository;
    }

    public String deletePosition(int positionId) {
        if (!repository.positionExists(positionId)) {
            return Constants.DELETE_WRONGID_MSG;
        }

        int affectedRows = repository.deletePosition(positionId);

        if (affectedRows > 0) {
            return Constants.DELETE_SUCCESS_MSG;
        } else {
            return Constants.DELETE_FAILURE_MSG;
        }
    }
}
