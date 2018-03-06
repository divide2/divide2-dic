package com.divide2.label

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * create by bvvy
 */
@Controller
@RequestMapping("/v1/label")
class LabelController(val labelRepository: LabelRepository)

