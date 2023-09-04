package com.bankchallenge.view.controller;

import com.bankchallenge.business.dto.BlogsDto;
import com.bankchallenge.business.dto.ReadersDto;
import com.bankchallenge.business.service.BlogsService;
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
public class BlogsController {

    @Getter
    @Setter
    private BlogsDto blogsDto;

    @Getter
    @Setter
    private List<BlogsDto> listDatatable;

    @Getter
    @Setter
    private List<BlogsDto> selectRows;

    @Autowired
    private BlogsService service;


    @PostConstruct
    public void init() {
        load();
    }

    public void save() {
        if (service.isExistReader(this.blogsDto)) {
            MessageUtil.addMessageError("El blog " + this.blogsDto.getTitle() + " ya existe");
        } else {
            service.save(this.blogsDto);
            MessageUtil.addMessageInfo("Se ha guardado correctamente!");
            PrimeFaces.current().executeScript("PF('readerDialog').hide()");
            load();
        }
    }

    public void deleteRows() {
        service.delete(this.selectRows);
        MessageUtil.addMessageInfo("Se ha eliminado correctamente!");
        load();

    }

    public void onRowEdit(RowEditEvent<BlogsDto> event) {
        if (service.isExistReaderById(event.getObject().getTitle(), event.getObject().getId())) {
            MessageUtil.addMessageError("El blog " + event.getObject().getTitle() + " ya existe");
        } else {
            service.save(event.getObject());
            MessageUtil.addMessageInfo("Blog editado " + event.getObject().getTitle());
        }
        load();
    }

    public void onRowCancel(RowEditEvent<BlogsDto> event) {
        MessageUtil.addMessageInfo("Edición cancelada " + event.getObject().getTitle());
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
        blogsDto = new BlogsDto();
        selectRows = new ArrayList<>();
        listDatatable = service.getAll();
    }


}
