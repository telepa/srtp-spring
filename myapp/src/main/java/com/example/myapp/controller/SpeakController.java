package com.example.myapp.controller;
import com.example.myapp.service.SpeakInfoService;
import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

//get files
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
//get files end


import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class SpeakController {
    @Autowired
    SpeakInfoService speakService;
    @RequestMapping(value="/Speak",method= RequestMethod.GET)
    public String Speak() throws ExecutionException, InterruptedException {
        SpeechConfig speechConfig = SpeechConfig.fromSubscription("18021b5f94a04dcbaff51d60071225e5", "eastus");
        speechConfig.setSpeechRecognitionLanguage("zh-cn");
        AudioConfig audioConfig = AudioConfig.fromDefaultMicrophoneInput();
        SpeechRecognizer speechRecognizer = new SpeechRecognizer(speechConfig, audioConfig);
        System.out.println("Speak into your microphone.");
        Future<SpeechRecognitionResult> task = speechRecognizer.recognizeOnceAsync();
        SpeechRecognitionResult result = task.get();
        System.out.println("RECOGNIZED: Text=" + result.getText());
        speakService.setContent(result.getText());
        return result.getText();
    }
    @GetMapping("/audio/{filename}")
    public ResponseEntity<byte[]> getAudio(@PathVariable String filename) throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/audio/" + filename);
        byte[] audioBytes = IOUtils.toByteArray(in);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.parse("attachment; filename=\"" + filename + "\""));
        return new ResponseEntity<>(audioBytes, headers, HttpStatus.OK);
    }
}
