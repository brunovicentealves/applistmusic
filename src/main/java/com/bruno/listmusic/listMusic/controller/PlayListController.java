package com.bruno.listmusic.listMusic.controller;

import com.bruno.listmusic.listMusic.domain.Playlist;
import com.bruno.listmusic.listMusic.service.PlayListService;
<<<<<<< HEAD
import com.bruno.listmusic.listMusic.util.GeneratePdfReportPlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
<<<<<<< HEAD
import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class PlayListController  {
=======

@Controller
@RequestMapping("playlists")
public class PlayListController {
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480

    @Autowired
    private PlayListService playListService;

<<<<<<< HEAD
    @GetMapping("playlists/listar")
=======
    @GetMapping("/listar")
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("playlists", playListService.recuperar());
        return new ModelAndView("playlist/list", model);
    }


<<<<<<< HEAD
    @GetMapping("playlists/cadastro")
=======
    @GetMapping("/cadastro")
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
    public String preSalvar(@ModelAttribute("playlist") Playlist playlist) {
        return "playlist/add";
    }

<<<<<<< HEAD
    @PostMapping("playlists/salvar")
=======
    @PostMapping("/salvar")
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
    public String salvar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "playlist/add";
        }
        playListService.salvar(playlist);
        attr.addFlashAttribute("mensagem", "Playlist criada com sucesso.");
        return "redirect:/playlists/listar";
    }

<<<<<<< HEAD
    @GetMapping("playlists/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Playlist playlist = playListService.recuperarPorId(id);
        model.addAttribute("playlist", playlist);
        return new ModelAndView("playlist/edit",model);
    }


    @PostMapping("playlists/editar")
    public ModelAndView atualizar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("playlist/edit");
=======
    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Playlist playlist = playListService.recuperarPorId(id);
        model.addAttribute("playlist", playlist);
        return new ModelAndView("/playlist/edit", model);
    }


    @PostMapping("/editar")
    public ModelAndView atualizar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/playlist/edit");
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
        }

       playListService.atualizar(playlist);
        attr.addFlashAttribute("mensagem", "Playlist atualizada com sucesso.");
        return new ModelAndView("redirect:/playlists/listar");
    }

<<<<<<< HEAD
    @GetMapping("playlists/{id}/remover")
=======
    @GetMapping("/{id}/remover")
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
    public String remover(@PathVariable("id") long id , RedirectAttributes attr){
        playListService.excluir(id);

        return "redirect:/playlists/listar";
    }

<<<<<<< HEAD
    @GetMapping("playlists/export")
   public ResponseEntity<InputStreamResource> playlistReport(){
        List<Playlist> listaPlayList  = (List<Playlist>)playListService.recuperar();
        ByteArrayInputStream bis = GeneratePdfReportPlayList.citiesReport(listaPlayList);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", "inline; filename=playlistpdf.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

=======
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
}
