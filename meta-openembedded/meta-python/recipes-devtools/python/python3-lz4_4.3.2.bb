DESCRIPTION = "python bindings for the lz4 compression library by Yann Collet"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6231efa4dd4811e62407314d90a57573"

DEPENDS += " \
    lz4 \
    python3-setuptools-scm-native \
    python3-pkgconfig-native \
"

SRC_URI += "file://run-ptest"

SRC_URI[sha256sum] = "e1431d84a9cfb23e6773e72078ce8e65cad6745816d4cbf9ae67da5ea419acda"

inherit pkgconfig pypi python_setuptools_build_meta ptest

RDEPENDS:${PN}-ptest += "\
    python3-coverage \
    python3-pytest \
    python3-pytest-cov \
    python3-pytest-runner \
    python3-multiprocessing \
    python3-psutil \
"

do_install_ptest() {
    cp -rf ${S}/tests/ ${D}${PTEST_PATH}/
    # The stream API is experimental and not enabled yet, so don't ship the test suite
    rm -rf ${D}${PTEST_PATH}/tests/stream
}

BBCLASSEXTEND = "native nativesdk"
