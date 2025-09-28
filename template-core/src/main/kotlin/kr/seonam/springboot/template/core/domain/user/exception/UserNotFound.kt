package kr.seonam.springboot.template.core.domain.user.exception

import kr.seonam.springboot.template.common.exception.NotFoundException

class UserNotFound(private val userId: Long) : NotFoundException("$userId 유저를 찾을 수 없습니다.")
