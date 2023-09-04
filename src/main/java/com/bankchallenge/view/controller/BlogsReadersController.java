package com.bankchallenge.view.controller;

import com.bankchallenge.business.dto.BlogsDto;
import com.bankchallenge.business.dto.BlogsReadersDto;
import com.bankchallenge.business.dto.ReadersDto;
import com.bankchallenge.business.service.BlogsReadersService;
import com.bankchallenge.business.service.BlogsService;
import com.bankchallenge.business.service.ReadersService;
import com.bankchallenge.util.MessageUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class BlogsReadersController {

    private Long id;

    @Getter
    @Setter
    private BlogsDto blogsDto;

    @Getter
    @Setter
    private ReadersDto readersDto;

    @Getter
    @Setter
    private List<ReadersDto> listReaders;

    @Getter
    @Setter
    private List<BlogsReadersDto> listDatatable;

    @Getter
    @Setter
    private List<BlogsReadersDto> selectRows;

    @Getter
    @Setter
    private List<BlogsDto> listBlogs;

    @Autowired
    private ReadersService readersService;

    @Autowired
    private BlogsService blogsService;

    @Autowired
    private BlogsReadersService blogsReadersService;


    public void openDialog() {
        readersDto = new ReadersDto();
        blogsDto = new BlogsDto();
        id = null;

    }

    public void openDialogEdit(final BlogsReadersDto blogsReadersDto) {
        readersDto = blogsReadersDto.getReader();
        loadBlogByReader();
        blogsDto = blogsReadersDto.getBlog();
        id = blogsReadersDto.getId();
    }

    public void loadBlogByReader() {
        if (this.readersDto != null) {
            listBlogs = blogsService.getBlobs(this.readersDto.getId());
        } else {
            listBlogs = new ArrayList<>();
        }
    }

    public void save() {
        blogsReadersService.save(this.id, this.blogsDto, this.readersDto);
        MessageUtil.addMessageInfo("Se ha guardado correctamente!");
        PrimeFaces.current().executeScript("PF('readerDialog').hide()");
        load();
    }


    @PostConstruct
    public void init() {
        load();
    }

    private void load() {
        blogsDto = new BlogsDto();
        readersDto = new ReadersDto();
        selectRows = new ArrayList<>();
        listDatatable = blogsReadersService.getAll();
        listReaders = readersService.getAll();
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

    public void deleteRows() {
        MessageUtil.addMessageInfo("Se ha eliminado correctamente!");
        blogsReadersService.delete(selectRows);
        load();

    }
}
