package eu.darken.sdmse.analyzer.core.content

import eu.darken.sdmse.analyzer.core.AnalyzerTask
import eu.darken.sdmse.analyzer.core.device.DeviceStorage
import eu.darken.sdmse.common.ca.CaString
import eu.darken.sdmse.common.ca.toCaString
import eu.darken.sdmse.common.files.APath
import eu.darken.sdmse.common.pkgs.features.Installed
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentDeleteTask(
    val storageId: DeviceStorage.Id,
    val groupId: ContentGroup.Id,
    val targetPkg: Installed.InstallId? = null,
    val targets: Set<APath>,
) : AnalyzerTask {

    @Parcelize
    data class Result(
        private val itemCount: Int,
    ) : AnalyzerTask.Result {
        override val primaryInfo: CaString
            get() = eu.darken.sdmse.common.R.string.general_result_success_message.toCaString()
    }
}