package kr.seonam.springboottemplate.core.domain.user.exception

import kr.seonam.springboottemplate.common.exception.NotFoundException

class UserNotFound(
    private val userId: Long,
) : NotFoundException("$userId 유저를 찾을 수 없습니다.")
