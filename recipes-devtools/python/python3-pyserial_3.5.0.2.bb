# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- LICENSE.txt
# +++ LICENSE.txt
# @@ -1,4 +1,4 @@
# -Copyright (c) 2001-2016 Chris Liechti <cliechti@gmx.net>
# +Copyright (c) 2001-2020 Chris Liechti <cliechti@gmx.net>
#  All Rights Reserved.
#  
#  Redistribution and use in source and binary forms, with or without
# 
#

SUMMARY = "Serial Port Support for Python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=520e45e59fc2cf94aa53850f46b86436"

inherit pypi setuptools3

PYPI_PACKAGE = "pyserial-labgrid"
PYPI_PACKAGE_SDIST = "pyserial-labgrid"

SRC_URI[sha256sum] = "98f826609795e92157ba2c2e9d8e98c6cec2f399de353f76dd0436536f5c52ab"

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
