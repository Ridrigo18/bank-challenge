package com.bankchallenge.view.controller;

import com.bankchallenge.business.dto.ReadersDto;
import com.bankchallenge.business.service.ReadersService;
import com.bankchallenge.util.MessageUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ReadersController {

    @Getter
    @Setter
    private ReadersDto readersDto;

    @Getter
    @Setter
    private List<ReadersDto> listDatatable;

    @Getter
    @Setter
    private List<ReadersDto> selectRows;

    @Autowired
    private ReadersService readersService;


    @PostConstruct
    public void init() {
        load();
    }

    public void save() {
        if (readersService.isExistReader(this.readersDto)) {
            MessageUtil.addMessageError("El lector " + this.readersDto.getName() + " ya existe");
        } else {
            readersService.save(this.readersDto);
            MessageUtil.addMessageInfo("Se ha guardado correctamente!");
            PrimeFaces.current().executeScript("PF('readerDialog').hide()");
            load();
        }
    }

    public void deleteRows() {
        readersService.delete(this.selectRows);
        MessageUtil.addMessageInfo("Se ha eliminado correctamente!");
        load();

    }

    public void onRowEdit(RowEditEvent<ReadersDto> event) {
        if (readersService.isExistReaderById(event.getObject().getName(), event.getObject().getId())) {
            MessageUtil.addMessageError("El lector " + event.getObject().getName() + " ya existe");
        } else {
            readersService.save(event.getObject());
            MessageUtil.addMessageInfo("Lector editado " + event.getObject().getName());
        }
        load();
    }

    public void onRowCancel(RowEditEvent<ReadersDto> event) {
        MessageUtil.addMessageInfo("Edición cancelada " + event.getObject().getName());
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectRows.size();
            return size > 1 ? size + " registros seleccionados " : "1 registro seleccionado";
        }

        return "Eliminar";
    }

    public boolean hasSelectedProducts() {
        return this.selectRows != null && !this.selectRows.isEmpty();
    }


    private void load() {
        readersDto = new ReadersDto();
        selectRows = new ArrayList<>();
        listDatatable = readersService.getAll();
    }


}
