SUMMARY = "Serial Port Support for Python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d476d94926db6e0008a5b3860d1f5c0d"

inherit pypi setuptools3

PYPI_PACKAGE = "pyserial-labgrid"
PYPI_PACKAGE_SDIST = "pyserial-labgrid"

SRC_URI[sha256sum] = "be4229a6b704dfd2b84362c3c10348578cc84b8e08556900aa7b3116ebf2f8c6"

do_install:append() {
    rm -f ${D}${bindir}/miniterm.py
    rmdir ${D}${bindir}
}

PACKAGES =+ "${PN}-java ${PN}-osx ${PN}-win32 ${PN}-tools"

FILES:${PN}-java = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*java* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*java* \
"

FILES:${PN}-osx = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/*osx* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/*osx* \
"

FILES:${PN}-win32 = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*serialcli* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*serialcli* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*win32* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*win32* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/miniterm* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/miniterm* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/*windows* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/*windows* \
"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-fcntl \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-threading \
"
