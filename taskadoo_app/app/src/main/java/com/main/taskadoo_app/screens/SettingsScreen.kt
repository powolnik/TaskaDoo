package com.main.taskadoo_app.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.main.taskadoo_app.src.TDRow

/**
 * Data class representing application settings.
 */
data class AppSettings(
	val darkMode: DarkModePreference = DarkModePreference.SYSTEM,
	val sortOrder: SortOrder = SortOrder.NEWEST_FIRST,
	val gridLayout: Boolean = true,
	val notificationEnabled: Boolean = true,
	val autoSave: Boolean = true,
	val syncEnabled: Boolean = false,
	val fontScale: Float = 1.0f
)

/**
 * Enum defining available dark mode preferences.
 */
enum class DarkModePreference {
	LIGHT, DARK, SYSTEM;

	/**
	 * Converts the enum value to a user-friendly display string.
	 */
	fun toDisplayString(): String {
		return when (this) {
			LIGHT -> "Light"
			DARK -> "Dark"
			SYSTEM -> "System default"
		}
	}
}

/**
 * Enum defining available note sorting orders.
 */
enum class SortOrder {
	NEWEST_FIRST, OLDEST_FIRST, ALPHABETICAL, LAST_MODIFIED;

	/**
	 * Converts the enum value to a user-friendly display string.
	 */
	fun toDisplayString(): String {
		return when (this) {
			NEWEST_FIRST -> "Newest first"
			OLDEST_FIRST -> "Oldest first"
			ALPHABETICAL -> "Alphabetical"
			LAST_MODIFIED -> "Last modified"
		}
	}
}

/**
 * ViewModel managing the settings state and providing functions to update them.
 */
class SettingsViewModel : ViewModel() {
	private val _settings = mutableStateOf(AppSettings())
	val settings: State<AppSettings> = _settings

	fun updateDarkMode(preference: DarkModePreference) {
		_settings.value = _settings.value.copy(darkMode = preference)
		// TODO: Implement persistence
	}

	fun updateSortOrder(order: SortOrder) {
		_settings.value = _settings.value.copy(sortOrder = order)
		// TODO: Implement persistence
	}

	fun toggleGridLayout(enabled: Boolean) {
		_settings.value = _settings.value.copy(gridLayout = enabled)
		// TODO: Implement persistence
	}

	fun toggleNotifications(enabled: Boolean) {
		_settings.value = _settings.value.copy(notificationEnabled = enabled)
		// TODO: Implement persistence
	}

	fun toggleAutoSave(enabled: Boolean) {
		_settings.value = _settings.value.copy(autoSave = enabled)
		// TODO: Implement persistence
	}

	fun toggleSync(enabled: Boolean) {
		_settings.value = _settings.value.copy(syncEnabled = enabled)
		// TODO: Implement persistence and authentication flow
	}

	fun updateFontScale(scale: Float) {
		_settings.value = _settings.value.copy(fontScale = scale)
		// TODO: Implement persistence
	}
}

/**
 * Composable function for displaying the settings screen.
 *
 * @param navController Navigation controller for handling navigation.
 * @param viewModel ViewModel managing the settings state.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
	navController: NavController = rememberNavController(),
	viewModel: SettingsViewModel = viewModel()
) {
	val settings by viewModel.settings
	val context = LocalContext.current

	var showDarkModeDialog by remember { mutableStateOf(false) }
	var showSortOrderDialog by remember { mutableStateOf(false) }

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("Settings") },
				navigationIcon = {
					IconButton(onClick = { navController.navigateUp() }) {
						Icon(Icons.Default.ArrowBack, contentDescription = "Back")
					}
				}
			)
		}
	) { paddingValues ->
		Column(
			modifier = Modifier
				.padding(paddingValues)
				.fillMaxSize()
				.verticalScroll(rememberScrollState())
		) {
			// Appearance Section
			SettingsSectionHeader("Appearance")

			// Theme setting
			SettingsItem(
				title = "Theme",
				description = settings.darkMode.toDisplayString(),
//				icon = Icons.Outlined.DarkMode,
				onClick = { showDarkModeDialog = true }
			)

			// Font scale setting
			Column(modifier = Modifier.padding(horizontal = 16.dp)) {
				Row(
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 12.dp),
					verticalAlignment = Alignment.CenterVertically
				) {
//					Icon(
//						imageVector = Icons.Outlined.TextFields,
//						contentDescription = null,
//						modifier = Modifier.size(24.dp)
//					)

					Spacer(modifier = Modifier.width(16.dp))

					Text(
						text = "Text Size",
						style = MaterialTheme.typography.bodyLarge
					)
				}

				Slider(
					value = settings.fontScale,
					onValueChange = { viewModel.updateFontScale(it) },
					valueRange = 0.8f..1.2f,
					steps = 4,
					modifier = Modifier.padding(horizontal = 12.dp)
				)

				TDRow(modifier = Modifier.fillMaxWidth(),
					vertivalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.Center
				) {
					Text("Small", style = MaterialTheme.typography.bodySmall)
					Text("Normal", style = MaterialTheme.typography.bodySmall)
					Text("Large", style = MaterialTheme.typography.bodySmall)
				}

				Spacer(modifier = Modifier.height(8.dp))
			}

			// Grid layout toggle
			SettingsSwitch(
				title = "Grid View",
				description = "Display notes in a grid layout instead of a list",
//				icon = Icons.Outlined.GridView,
				isChecked = settings.gridLayout,
				onCheckedChange = { viewModel.toggleGridLayout(it) }
			)

			Divider(modifier = Modifier.padding(vertical = 8.dp))

			// Notes Section
			SettingsSectionHeader("Notes")

			// Sort order setting
			SettingsItem(
				title = "Sort Order",
				description = settings.sortOrder.toDisplayString(),
//				icon = Icons.Outlined.Sort,
				onClick = { showSortOrderDialog = true }
			)

			// Auto save toggle
			SettingsSwitch(
				title = "Auto Save",
				description = "Automatically save changes to notes",
//				icon = Icons.Outlined.Save,
				isChecked = settings.autoSave,
				onCheckedChange = { viewModel.toggleAutoSave(it) }
			)

			Divider(modifier = Modifier.padding(vertical = 8.dp))

			// Notifications Section
			SettingsSectionHeader("Notifications")

			// Notifications toggle
			SettingsSwitch(
				title = "Note Reminders",
				description = "Receive notifications for note reminders",
//				icon = Icons.Outlined.Notifications,
				isChecked = settings.notificationEnabled,
				onCheckedChange = { viewModel.toggleNotifications(it) }
			)

			Divider(modifier = Modifier.padding(vertical = 8.dp))

			// Cloud Section
			SettingsSectionHeader("Cloud")

			// Sync toggle
			SettingsSwitch(
				title = "Sync Notes",
				description = "Automatically sync notes across devices",
//				icon = Icons.Outlined.CloudSync,
				isChecked = settings.syncEnabled,
				onCheckedChange = { viewModel.toggleSync(it) }
			)

			Divider(modifier = Modifier.padding(vertical = 8.dp))

			// About Section
			SettingsSectionHeader("About")

			// App Version
			SettingsItem(
				title = "App Version",
				description = "1.0.0",
//				icon = Icons.Outlined.Info,
				onClick = { /* No action */ }
			)

			// Privacy Policy
			SettingsItem(
				title = "Privacy Policy",
				description = "Read our privacy policy",
//				icon = Icons.Outlined.Security,
				onClick = { /* TODO: Open privacy policy */ }
			)

			// Terms of Service
			SettingsItem(
				title = "Terms of Service",
				description = "Read our terms of service",
//				icon = Icons.Outlined.Description,
				onClick = { /* TODO: Open terms of service */ }
			)

			Spacer(modifier = Modifier.height(24.dp))
		}
	}

	// Dark Mode Dialog
	if (showDarkModeDialog) {
		AlertDialog(
			onDismissRequest = { showDarkModeDialog = false },
			title = { Text("Choose Theme") },
			text = {
				Column {
					DarkModePreference.values().forEach { preference ->
						Row(
							modifier = Modifier
								.fillMaxWidth()
								.padding(vertical = 8.dp)
								.clickable {
									viewModel.updateDarkMode(preference)
									showDarkModeDialog = false
								},
							verticalAlignment = Alignment.CenterVertically
						) {
							RadioButton(
								selected = settings.darkMode == preference,
								onClick = {
									viewModel.updateDarkMode(preference)
									showDarkModeDialog = false
								}
							)
							Spacer(modifier = Modifier.width(8.dp))
							Text(preference.toDisplayString())
						}
					}
				}
			},
			confirmButton = {
				TextButton(onClick = { showDarkModeDialog = false }) {
					Text("Cancel")
				}
			}
		)
	}

	// Sort Order Dialog
	if (showSortOrderDialog) {
		AlertDialog(
			onDismissRequest = { showSortOrderDialog = false },
			title = { Text("Sort Notes By") },
			text = {
				Column {
					SortOrder.values().forEach { order ->
						Row(
							modifier = Modifier
								.fillMaxWidth()
								.padding(vertical = 8.dp)
								.clickable {
									viewModel.updateSortOrder(order)
									showSortOrderDialog = false
								},
							verticalAlignment = Alignment.CenterVertically
						) {
							RadioButton(
								selected = settings.sortOrder == order,
								onClick = {
									viewModel.updateSortOrder(order)
									showSortOrderDialog = false
								}
							)
							Spacer(modifier = Modifier.width(8.dp))
							Text(order.toDisplayString())
						}
					}
				}
			},
			confirmButton = {
				TextButton(onClick = { showSortOrderDialog = false }) {
					Text("Cancel")
				}
			}
		)
	}
}


/**
 * Composable function to display a settings section header.
 *
 * @param title Title of the section.
 */
@Composable
fun SettingsSectionHeader(title: String) {
	Text(
		text = title,
		style = MaterialTheme.typography.titleMedium,
		color = MaterialTheme.colorScheme.primary,
		modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
	)
}

/**
 * Composable function to display a settings item.
 *
 * @param title Title of the setting.
 * @param description Description of the setting.
 * @param onClick Callback when the item is clicked.
 */
@Composable
fun SettingsItem(
	title: String,
	description: String,
//	icon: androidx.compose.ui.graphics.vector.ImageVector,
	onClick: () -> Unit
) {
	TDRow(
		modifier = Modifier
			.fillMaxWidth()
			.clickable(onClick = onClick)
			.padding(horizontal = 16.dp, vertical = 12.dp),
		vertivalAlignment = Alignment.CenterVertically
	) {
//		Icon(
//			imageVector = icon,
//			contentDescription = null,
//			modifier = Modifier.size(24.dp)
//		)

		Spacer(modifier = Modifier.width(16.dp))

		Column(modifier = Modifier.weight(1f)) {
			Text(
				text = title,
				style = MaterialTheme.typography.bodyLarge
			)

			if (description.isNotEmpty()) {
				Text(
					text = description,
					style = MaterialTheme.typography.bodyMedium,
					color = MaterialTheme.colorScheme.onSurfaceVariant,
					overflow = TextOverflow.Ellipsis,
					maxLines = 1,
					modifier = Modifier.alpha(0.7f)
				)
			}
		}

		Spacer(modifier = Modifier.width(8.dp))

		Icon(
			imageVector = Icons.Default.KeyboardArrowRight,
			contentDescription = null,
			tint = MaterialTheme.colorScheme.onSurfaceVariant,
			modifier = Modifier.alpha(0.7f)
		)
	}
}

@Composable
fun SettingsSwitch(
	title: String,
	description: String,
//	icon: androidx.compose.ui.graphics.vector.ImageVector,
	isChecked: Boolean,
	onCheckedChange: (Boolean) -> Unit
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 16.dp, vertical = 12.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
//		Icon(
//			imageVector = icon,
//			contentDescription = null,
//			modifier = Modifier.size(24.dp)
//		)

		Spacer(modifier = Modifier.width(16.dp))

		Column(modifier = Modifier.weight(1f)) {
			Text(
				text = title,
				style = MaterialTheme.typography.bodyLarge
			)

			if (description.isNotEmpty()) {
				Text(
					text = description,
					style = MaterialTheme.typography.bodyMedium,
					color = MaterialTheme.colorScheme.onSurfaceVariant,
					overflow = TextOverflow.Ellipsis,
					maxLines = 2,
					modifier = Modifier.alpha(0.7f)
				)
			}
		}

		Spacer(modifier = Modifier.width(8.dp))

		Switch(
			checked = isChecked,
			onCheckedChange = onCheckedChange
		)
	}
}

@Preview(showBackground = true)
@Composable
fun Preview(){
	SettingsScreen(navController = rememberNavController())
}
