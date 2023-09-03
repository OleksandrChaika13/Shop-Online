package org.example.app.controllers.positions;

import org.example.app.services.positions.PositionDeleteService;
import org.example.app.utils.AppStarter;
import org.example.app.views.positions.PositionDeleteView;

public class PositionDeleteController {

    private final PositionDeleteService service;
    private final PositionDeleteView view;

    public PositionDeleteController(PositionDeleteService service, PositionDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deletePosition() {
        int positionId = view.getPositionId();
        if (positionId != -1) {
            String result = service.deletePosition(positionId);
            view.getOutput(result);
            AppStarter.startApp();
        }
    }
}
