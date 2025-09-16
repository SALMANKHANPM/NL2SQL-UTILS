package org.dialectConvertor.controller;

import org.dialectConvertor.dto.TranslationRequest;
import org.dialectConvertor.dto.TranslationResponse;
import org.dialectConvertor.service.SqlTranslationService;
import org.jooq.SQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow requests from Python app
public class TranslationController {

    @Autowired
    private SqlTranslationService translationService;

    @PostMapping("/translate")
    public ResponseEntity<TranslationResponse> translateSql(@RequestBody TranslationRequest request) {
        try {
            SQLDialect source = SQLDialect.valueOf(request.getSourceDialect().toUpperCase());
            SQLDialect target = SQLDialect.valueOf(request.getTargetDialect().toUpperCase());

            String translated = translationService.translate(request.getSql(), source, target);
            return ResponseEntity.ok(new TranslationResponse(translated));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}