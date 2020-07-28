package com.bruno.listmusic.listMusic.controller;

import com.bruno.listmusic.listMusic.domain.Musica;
<<<<<<< HEAD
import com.bruno.listmusic.listMusic.domain.Playlist;
import com.bruno.listmusic.listMusic.service.MusicaService;
import com.bruno.listmusic.listMusic.service.PlayListService;
import com.bruno.listmusic.listMusic.util.GeneratePdfReportMusica;
import com.bruno.listmusic.listMusic.util.GeneratePdfReportPlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
=======
import com.bruno.listmusic.listMusic.service.MusicaService;
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
@RequestMapping("/playlists/{playlistId}/musicas")
public class MusicaController  {
=======

@Controller
@RequestMapping("/playlists/{playlistId}/musicas")
public class MusicaController {
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480

    @Autowired
    private MusicaService musicaService;

<<<<<<< HEAD
    @Autowired
    private PlayListService playListService;

=======
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
    @GetMapping("/listar")
    public ModelAndView listar(@PathVariable("playlistId") long playlistId, ModelMap model) {
        model.addAttribute("musicas", musicaService.recuperarPorPlayList(playlistId));
        model.addAttribute("playlistId", playlistId);
        return new ModelAndView("musica/list", model);
    }

    @GetMapping("/cadastro")
    public String presalva(@ModelAttribute("musica")Musica musica , @PathVariable("playlistId") long playlistId){
        return "musica/add";
    }

    @PostMapping("/salvar")
    public String salvar(@PathVariable("playlistId") long playlistId, @Valid @ModelAttribute("musica")
            Musica musica, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "musica/add";
        }
        musicaService.salvar(musica, playlistId);
        attr.addFlashAttribute("mensagem", "Música salva com sucesso.");
        return "redirect:/playlists/" + playlistId + "/musicas/listar";
    }

    @GetMapping("/{musicaId}/atualizar")
<<<<<<< HEAD
        public ModelAndView preAtualizar(@PathVariable("playlistId") long playlistId, @PathVariable("musicaId")
        long musicaId, ModelMap model) {
            Musica musica = musicaService.recuperarPorPlaylistIdEMusicaId(playlistId, musicaId);
            model.addAttribute("musica", musica);
            model.addAttribute("playlistId", playlistId);
            return new ModelAndView("musica/edit", model);
        }

        @PostMapping ("/editar")
        public ModelAndView atualizar(@PathVariable("playlistId") long playlistId, @Valid @ModelAttribute("musica")
        Musica musica, BindingResult result, RedirectAttributes attr) {
            if (result.hasErrors()) {
                return new ModelAndView("musica/add");
            }

            musicaService.atualizar(musica, playlistId);
            attr.addFlashAttribute("mensagem", "Música atualizada com sucesso.");
            return new ModelAndView("redirect:/playlists/" + playlistId + "/musicas/listar");
        }


        @GetMapping("/{musicaId}/remover")
        public String remover(@PathVariable("playlistId") long playlistId, @PathVariable("musicaId")
        long musicaId, RedirectAttributes attr) {
            musicaService.excluir(playlistId, musicaId);
            attr.addFlashAttribute("mensagem", "Música excluída com sucesso.");
            return "redirect:/playlists/" + playlistId + "/musicas/listar";
        }

        @GetMapping("/export")
        public ResponseEntity<InputStreamResource> playlistReport(@PathVariable("playlistId") long playlistId){
            List<Musica> listMusica  = (List<Musica>)musicaService.recuperarPorPlayList(playlistId);
            Playlist playlist = playListService.recuperarPorId(playlistId);
            ByteArrayInputStream bis = GeneratePdfReportMusica.citiesReport(listMusica , playlist);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", "inline; filename=listaMusicaspdf.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
=======
    public ModelAndView preAtualizar(@PathVariable("playlistId") long playlistId, @PathVariable("musicaId")
            long musicaId, ModelMap model) {
        Musica musica = musicaService.recuperarPorPlaylistIdEMusicaId(playlistId, musicaId);
        model.addAttribute("musica", musica);
        model.addAttribute("playlistId", playlistId);
        return new ModelAndView("musica/edit", model);
    }

    @PostMapping ("/editar")
    public ModelAndView atualizar(@PathVariable("playlistId") long playlistId, @Valid @ModelAttribute("musica")
            Musica musica, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("musica/add");
        }

        musicaService.atualizar(musica, playlistId);
        attr.addFlashAttribute("mensagem", "Música atualizada com sucesso.");
        return new ModelAndView("redirect:/playlists/" + playlistId + "/musicas/listar");
    }


    @GetMapping("/{musicaId}/remover")
    public String remover(@PathVariable("playlistId") long playlistId, @PathVariable("musicaId")
            long musicaId, RedirectAttributes attr) {
        musicaService.excluir(playlistId, musicaId);
        attr.addFlashAttribute("mensagem", "Música excluída com sucesso.");
        return "redirect:/playlists/" + playlistId + "/musicas/listar";
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
    }



}
